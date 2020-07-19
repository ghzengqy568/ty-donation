/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.dao.base.BaseSQL;
import com.baidu.mapp.bcd.dao.base.SQLParam;
import com.baidu.mapp.bcd.domain.*;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.dto.LoginUser;
import com.baidu.mapp.bcd.domain.dto.UserThreadLocal;
import com.baidu.mapp.bcd.domain.meta.MetaAllocation;
import com.baidu.mapp.bcd.domain.meta.MetaDonateDetail;
import com.baidu.mapp.bcd.service.*;
import com.google.gson.JsonObject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Schema(description = "拨款", name = "DonateController")
@RestController
@RequestMapping("/allocation")
public class AllocationController {

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityPlanService activityPlanService;

    @Autowired
    AllocationService allocationService;

    @Autowired
    DonateDetailService donateDetailService;

    @Autowired
    CertService certService;

    @Autowired
    PlanAllocationRelService planAllocationRelService;

    @Operation(method = "POST", description = "拨款")
    @PostMapping("execute/{activityId}")
    public R allocation(@RequestHeader("X-TOKEN") String xtoken, @Schema(description = "活动ID") @PathVariable("activityId") Long activityId) {

        LoginUser loginUser = UserThreadLocal.getLoginUser();
        Long adminUserId = null;
        if (loginUser != null) {
            adminUserId = loginUser.getUserId();
        }

        Activity activity = activityService.selectByPrimaryKey(activityId);

        if (activity == null) {
            return R.error(100101, "活动不存在");
        }

        if (activity.getStatus() != 0) {
            return R.error(100102, "活动已拨款");
        }

        // 计划款项是否能满足，可以先预分配
        List<ActivityPlan> activityPlans = activityPlanService.selectByExample(ActivityPlanExample.newBuilder()
                .build()
                .createCriteria()
                .andActivityIdEqualTo(activity.getId())
                .toExample()
        );

        if (CollectionUtils.isEmpty(activityPlans)) {
            return R.error(100103, "活动下面没有计划，不能实施");
        }

        // 计算资源是否充足
        long totalNeedCash = 0;
        for (ActivityPlan activityPlan : activityPlans) {
            totalNeedCash += activityPlan.getAmount();
        }

        BaseSQL sql = BaseSQL.newInstance().SELECT("sum(balance)").FROM(MetaDonateDetail.TABLE_NAME).WHERE("balance"
                + ">0 and type=1");
        Long totalBanlance = donateDetailService.selectOneLong(sql, SQLParam.newInstance());
        if (totalBanlance < totalNeedCash) {
            return R.error(100103, "资金池余额不足，无法拨款");
        }

        // 等待分配
        List<DonateDetail> payload = new ArrayList<>();
        long cut = 0;
        boolean over = false;
        int start = 0;
        int limit = 10;
        while (!over) {
            List<DonateDetail> details = donateDetailService.selectByExample(DonateDetailExample.newBuilder()
                    .start(start)
                    .limit(limit)
                    .orderByClause("id")
                    .build()
                    .createCriteria()
                    .andTypeEqualTo((byte) 1)
                    .andBalanceGreaterThan(0L)
                    .toExample()
            );
            if (details == null || details.isEmpty()) {
                over = true;
            } else {
                start += details.size();
                // 分配
                for (DonateDetail detail : details) {
                    cut += detail.getBalance();
                    payload.add(detail);
                    if (cut >= totalNeedCash) {
                        over = true;
                        break;
                    }
                }
            }
        }

        // 分配
        // 分配捐赠详情下标
        int idx = 0;
        int len = payload.size();
        for (ActivityPlan activityPlan : activityPlans) {
            Long planId = activityPlan.getId();
            Long amount = activityPlan.getAmount();
            while (amount > 0) {
                if (idx >= len) {
                    throw new IllegalArgumentException("配置错误！");
                }
                DonateDetail donateDetail = payload.get(idx);
                Long detailId = donateDetail.getId();
                Long b1 = donateDetail.getBalance();
                long used = 0;
                if (b1 <= amount) {
                    used = b1;
                    donateDetail.setBalance(0L);
                    amount -= b1;
                    b1 = 0L;

                    idx++;
                } else {
                    used = amount;
                    b1 -= amount;
                    donateDetail.setBalance(b1);
                    amount = 0L;
                }

                // 创建拨款记录
                String sign = SignUtils.sign(detailId, planId, b1, used);
                Allocation allocation = Allocation.newBuilder()
                        .balance(b1)
                        .used(used)
                        .certCode("")
                        .createTime(new Date())
                        .donateDetailId(detailId)
                        .sign(sign)
                        .build();

                allocationService.insertSelective(allocation);
                Long allocationId = allocation.getId();
                // 存证
                JsonObject chainContent = new JsonObject();
                chainContent.addProperty("balance", b1);
                chainContent.addProperty("used", used);
                chainContent.addProperty("detailId", detailId);
                String certCode = certService.writeChain(adminUserId, MetaAllocation.TABLE_NAME, allocationId, sign,
                        GsonUtils.toJsonString(chainContent));
                allocation.setCertCode(certCode);
                allocation.setLastModifyTime(new Date());
                allocationService.updateByPrimaryKeySelective(allocation);

                // 创建t_plan_allocation_rel
                PlanAllocationRel rel = PlanAllocationRel.newBuilder()
                        .activityPlanId(planId)
                        .createTime(new Date())
                        .balance(used)
                        .used(0L)
                        .lastModifyTime(new Date())
                        .allocationId(allocationId)
                        .build();

                planAllocationRelService.insertSelective(rel);

                donateDetailService.updateByPrimaryKeySelective(donateDetail);
            }
        }
        // 活动状态， 0-待拨款， 1-已拨款，2-已指派，3-领取中， 4-已结束
        activity.setStatus((byte)1);
        activity.setLastModifyTime(new Date());
        activityService.updateByPrimaryKeySelective(activity);
        return R.ok();
    }

}
