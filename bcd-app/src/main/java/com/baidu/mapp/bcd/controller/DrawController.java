/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.*;
import com.baidu.mapp.bcd.domain.dto.LoginUser;
import com.baidu.mapp.bcd.domain.dto.UserThreadLocal;
import com.baidu.mapp.bcd.domain.dto.UserType;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
import com.baidu.mapp.bcd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecord;
import com.baidu.mapp.bcd.dto.DrawReq;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "领取接口")
@RestController
@RequestMapping("/draw")
public class DrawController {

    @Autowired
    ActivityService activityService;

    @Autowired
    DonatoryService donatoryService;

    @Autowired
    DrawRecordService drawRecordService;

    @Autowired
    CertService certService;

    @Autowired
    DrawRecordDetailService drawRecordDetailService;

    @Autowired
    DrawRecordFlowService drawRecordFlowService;

    @Autowired
    AssignService assignService;

    @Autowired
    ActivityPlanService activityPlanService;

    @Autowired
    ActivityPlanConfigService activityPlanConfigService;

    @Autowired
    AllocationService allocationService;

    @Autowired
    PlanAllocationRelService planAllocationRelService;

    @PostMapping("draw")
    public R<String> draw(@RequestHeader("X-TOKEN") String xtoken, @RequestBody DrawReq drawReq) {

        LoginUser loginUser = UserThreadLocal.getLoginUser();
        if (loginUser == null) {
            return R.error(100102, "你尚未登录");
        }
        UserType userType = loginUser.getUserType();
        if (userType == null || !userType.isDonatory()) {
            return R.error(100102, "你无权访问");
        }

        // 参与的活动
        Long donatoryId = loginUser.getUserId();
        Long activityId = drawReq.getActivityId();

        if (activityId == null || activityId <= 0) {
            return R.error(100101, "活动ID不能为空");
        }
        if (donatoryId == null || donatoryId <= 0) {
            return R.error(100101, "受捐人ID不能为空");
        }

        Activity activity = activityService.selectByPrimaryKey(activityId);
        if (activity == null) {
            return R.error(100102, "活动不存在");
        }
        Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);
        if (donatory == null) {
            return R.error(100102, "受捐人不存在");
        }

        List<Assign> assigns = assignService.selectByExample(AssignExample.newBuilder().build().createCriteria()
                .andActivityIdEqualTo(activityId)
                .andDonatoryIdEqualTo(donatoryId)
                .toExample());
        if (CollectionUtils.isEmpty(assigns)) {
            return R.error(100102, "受捐人不是本次受捐对象");
        }

        // 是否已领取过了
        List<DrawRecord> drawRecords = drawRecordService.selectByExample(
                DrawRecordExample.newBuilder()
                        .build()
                        .createCriteria()
                        .andActivityIdEqualTo(activityId)
                        .andDonatoryIdEqualTo(donatoryId)
                        .toExample(),
                MetaDrawRecord.COLUMN_NAME_ID
        );
        if (!CollectionUtils.isEmpty(drawRecords)) {
            return R.error(100102, "受捐人已领取过了");
        }

        Date drawTime = new Date();
        String sign = SignUtils.sign(donatoryId, activityId, DateTimeUtils.toDateTimeString(drawTime,
                "yyyyMMddHHmmss"));
        DrawRecordFlow drawRecordFlow = DrawRecordFlow.newBuilder()
                .drawTime(new Date())
                .activityId(activityId)
                .donatoryId(donatoryId)
                .sign(sign)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .build();
        drawRecordFlowService.insertSelective(drawRecordFlow);

        String flowCertCode = certService.writeChain(donatoryId, MetaDrawRecordFlow.TABLE_NAME, drawRecordFlow.getId
                        (),
                sign);
        drawRecordFlow.setCertCode(flowCertCode);
        drawRecordFlow.setLastModifyTime(new Date());
        drawRecordFlowService.updateByPrimaryKeySelective(drawRecordFlow);

        Long drawFlowId = drawRecordFlow.getId();

        Map<Long, ActivityPlanConfig> configMap = activityPlanConfigService.selectMapByPrimaryKeys(
                assigns.stream().map(Assign :: getConfigId).collect(Collectors.toList()),
                ActivityPlanConfig :: getId
        );

        Map<Long, ActivityPlan> activityPlanMap =
                activityPlanService.selectMapByExample(ActivityPlanExample.newBuilder().build().createCriteria().
                                andActivityIdEqualTo(activityId).toExample(),
                        ActivityPlan::getId
                );

        for (Assign assign : assigns) {
            Long configId = assign.getConfigId();
            ActivityPlanConfig activityPlanConfig = configMap.get(configId);
            // 计划ID
            Long activityPlanId = activityPlanConfig.getActivityPlanId();
            // 领取份量
            Long quantity = activityPlanConfig.getQuantity();

            List<PlanAllocationRel> balance = balance(activityPlanId);

            boolean over = false;
            long needQuantity = quantity.longValue();
            while (!over && !CollectionUtils.isEmpty(balance)) {
                for (PlanAllocationRel planAllocationRel : balance) {
                    long balance1 = planAllocationRel.getBalance() == null ? 0 :
                            planAllocationRel.getBalance().longValue();
                    if (needQuantity <= balance1) {
                        planAllocationRel.setBalance(balance1 - needQuantity);
                        planAllocationRel.setUsed(planAllocationRel.getUsed().longValue() + needQuantity);
                        planAllocationRel.setLastModifyTime(new Date());
                        planAllocationRelService.updateByPrimaryKeySelective(planAllocationRel);
                        // 记录扣款详情
                        drawRecordDetailService.insertSelective(DrawRecordDetail.newBuilder()
                                .activityId(activityId)
                                .activityPlanId(activityPlanId)
                                .donatoryId(donatoryId)
                                .used(needQuantity)
                                .allocationId(planAllocationRel.getAllocationId())
                                .build());
                        needQuantity = 0;
                        over = true;
                    } else {
                        planAllocationRel.setBalance(0L);
                        planAllocationRel.setLastModifyTime(new Date());
                        planAllocationRel.setUsed(planAllocationRel.getUsed().longValue() + balance1);
                        planAllocationRelService.updateByPrimaryKeySelective(planAllocationRel);

                        // 记录扣款详情
                        drawRecordDetailService.insertSelective(DrawRecordDetail.newBuilder()
                                .activityId(activityId)
                                .activityPlanId(activityPlanId)
                                .donatoryId(donatoryId)
                                .used(balance1)
                                .allocationId(planAllocationRel.getAllocationId())
                                .build());
                        needQuantity -= balance1 ;
                    }
                }
                if (!over) {
                    balance = balance(activityPlanId);
                    if (CollectionUtils.isEmpty(balance)) {
                        return R.error("余额不足");
                    }
                }
            }
            if (!over) {
                return R.error("余额不足");
            }

            ActivityPlan activityPlan = activityPlanMap.get(activityPlanId);
            Byte type = activityPlan.getType();
            String unit = activityPlan.getUnit();
            Long personalQuantity = configMap.get(configId).getQuantity();
            String name = activityPlan.getName();
            String drSign = SignUtils.sign(drawFlowId, activityId, donatoryId, type, unit, personalQuantity, name);
            // 新增t_draw_record
            DrawRecord drawRecord = DrawRecord.newBuilder()
                    .drawRecordFlowId(drawFlowId)
                    .activityId(activityId)
                    .donatoryId(donatoryId)
                    .type(type)
                    .unit(unit)
                    .quantity(personalQuantity)
                    .name(name)
                    .sign(drSign)
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .build();
            drawRecordService.insertSelective(drawRecord);

            String drCert = certService.writeChain(donatoryId, MetaDrawRecord.TABLE_NAME, drawRecord.getId(), sign);
            drawRecord.setCertCode(drCert);
            drawRecord.setLastModifyTime(new Date());
            drawRecordService.updateByPrimaryKeySelective(drawRecord);
        }

        return R.ok(flowCertCode);
    }

    /**
     * 获取10条存在余额的数据
     * @param activityPlanId
     * @return
     */
    private List<PlanAllocationRel> balance(Long activityPlanId) {
        List<PlanAllocationRel> planAllocationRels = planAllocationRelService
                .selectByExample(PlanAllocationRelExample.newBuilder()
                        .limit(10)
                        .build()
                        .createCriteria()
                        .andBalanceGreaterThan(0L)
                        .andActivityPlanIdEqualTo(activityPlanId)
                        .toExample());
        return planAllocationRels;
    }

}
