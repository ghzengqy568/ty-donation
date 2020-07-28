/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.ChainConstants;
import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanConfig;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import com.baidu.mapp.bcd.domain.Assign;
import com.baidu.mapp.bcd.domain.AssignExample;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DrawRecord;
import com.baidu.mapp.bcd.domain.DrawRecordDetail;
import com.baidu.mapp.bcd.domain.DrawRecordExample;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.PlanAllocationRel;
import com.baidu.mapp.bcd.domain.PlanAllocationRelExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.dto.LoginUser;
import com.baidu.mapp.bcd.domain.dto.UserThreadLocal;
import com.baidu.mapp.bcd.domain.dto.UserType;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecord;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
import com.baidu.mapp.bcd.dto.DrawReq;
import com.baidu.mapp.bcd.service.ActivityPlanConfigService;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.AllocationService;
import com.baidu.mapp.bcd.service.AssignService;
import com.baidu.mapp.bcd.service.CertificateService;
import com.baidu.mapp.bcd.service.ChainService;
import com.baidu.mapp.bcd.service.DonatoryService;
import com.baidu.mapp.bcd.service.DrawRecordDetailService;
import com.baidu.mapp.bcd.service.DrawRecordFlowService;
import com.baidu.mapp.bcd.service.DrawRecordService;
import com.baidu.mapp.bcd.service.PlanAllocationRelService;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Schema(description = "领取接口")
@RestController
@RequestMapping("/draw")
@Slf4j
public class DrawController {

    @Autowired
    ActivityService activityService;

    @Autowired
    DonatoryService donatoryService;

    @Autowired
    DrawRecordService drawRecordService;

    @Autowired
    ChainService chainService;

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

    @Autowired
    Digest digest;

    @Autowired
    CertificateService certificateService;

    /**
     * 确认领取一笔善款
     */
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
        if (activity.getStatus()== null || activity.getStatus() < 2) {
            // 活动状态， 0-待拨款， 1-已拨款，2-已指派，3-领取中，4-已结束
            return R.error(100102, "活动尚未拨款或指派，不能领取");
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

        DrawRecordFlow drawRecordFlow = DrawRecordFlow.newBuilder()
                .drawTime(new Date())
                .activityId(activityId)
                .donatoryId(donatoryId)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .build();
        drawRecordFlowService.insertSelective(drawRecordFlow);

        JsonObject chainContent = new JsonObject();
        chainContent.addProperty("activityId", activityId);
        chainContent.addProperty("donatoryId", donatoryId);

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

        List<Map<String, Object>> drawDetailMapList = Lists.newArrayList();
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

            // WRITE_CHAIN 领取流水+详情一起作为关键信息一次性上链
            Map<String, Object> drawDetailMap = new HashMap<>();
            drawDetailMap.put(ChainConstants.DRAW_DETAIL_NAME, name);
            drawDetailMap.put(ChainConstants.DRAW_DETAIL_QUANTITY, personalQuantity);
            drawDetailMap.put(ChainConstants.DRAW_DETAIL_UNIT, unit);
            drawDetailMapList.add(drawDetailMap);
        }

        // WRITE_CHAIN 领取流水+详情一起作为关键信息一次性上链
        Map<String, Object> drawFlowMap = new HashMap<>();
        String drawTimeInString = DateTimeUtils.toDateTimeString(drawRecordFlow.getDrawTime(),
                "yyyy-MM-dd HH:mm:ss");
        drawFlowMap.put(ChainConstants.DRAw_FLOW_DONATORY_NAME, donatory.getDonatoryName());
        drawFlowMap.put(ChainConstants.DRAW_FLOW_DONATORY_ID_CARD, donatory.getIdcard());
        drawFlowMap.put(ChainConstants.DRAW_FLOW_DRAW_TIME, drawTimeInString);
        drawFlowMap.put(ChainConstants.DRAW_DETAIL, drawDetailMapList);
        String writeChainStr = GsonUtils.toJsonString(drawFlowMap);

        String sign = SignUtils.sign(donatory.getDonatoryName(), donatory.getIdcard(), drawTimeInString,
                drawDetailMapList);
        // 领取详情数据上链
        String address = chainService.writeChain(donatoryId, MetaDrawRecordFlow.TABLE_NAME,
                drawRecordFlow.getId(), sign, writeChainStr);
        drawRecordFlow.setSign(sign);
        drawRecordFlow.setCertCode(address);
        drawRecordFlow.setLastModifyTime(new Date());
        drawRecordFlowService.updateByPrimaryKeySelective(drawRecordFlow);

        if (activity.getStatus()!=null && activity.getStatus() == 2) {
            // 活动状态， 0-待拨款， 1-已拨款，2-已指派，3-领取中， 4-已结束
            activity.setStatus((byte)3);
            activity.setLastModifyTime(new Date());
            activityService.updateByPrimaryKeySelective(activity);
        }
        // 返回领取存证地址
        return R.ok(address);
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
