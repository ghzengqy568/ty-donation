/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.ActivityStatus;
import com.baidu.mapp.bcd.common.utils.ChainConstants;
import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityExample;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanConfig;
import com.baidu.mapp.bcd.domain.ActivityPlanConfigExample;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import com.baidu.mapp.bcd.domain.AssignExample;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaActivity;
import com.baidu.mapp.bcd.domain.meta.MetaActivityPlan;
import com.baidu.mapp.bcd.dto.ActivityDetailResp;
import com.baidu.mapp.bcd.dto.ActivityPlanConfigReq;
import com.baidu.mapp.bcd.dto.ActivityPlanConfigResp;
import com.baidu.mapp.bcd.dto.ActivityPlanDetailResp;
import com.baidu.mapp.bcd.dto.ActivityPlanReq;
import com.baidu.mapp.bcd.dto.ActivityReq;
import com.baidu.mapp.bcd.dto.ActivityResp;
import com.baidu.mapp.bcd.service.ActivityPlanConfigService;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.AssignService;
import com.baidu.mapp.bcd.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityPlanService activityPlanService;

    @Autowired
    private ActivityPlanConfigService activityPlanConfigService;

    @Autowired
    private AssignService assignService;

    @Autowired
    CertService certService;

    @PostMapping("/create")
    public R createActive(@RequestBody ActivityReq act) {

        List<ActivityPlanReq> activityPlanReqs = act.getActivityPlanReqList();
        if (CollectionUtils.isEmpty(activityPlanReqs)) {
            return R.error(100200, "请填写活动计划详情");
        }

        String desc = act.getDescription();
        String theme = act.getTheme();
        Date startTime = act.getStartTime();
        Date endTime = act.getEndTime();
        String startTimeInStr = DateTimeUtils.toDateTimeString(startTime, "yyyyMMddHHmmss");
        String endTimeInStr = DateTimeUtils.toDateTimeString(endTime, "yyyyMMddHHmmss");
        String actSign = SignUtils.sign(desc, theme, startTimeInStr, endTimeInStr);

        Activity activity = Activity.newBuilder()
                .description(desc)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .startTime(startTime)
                .endTime(endTime)
                .theme(theme)
                .status(ActivityStatus.INIT.getStatus())
                .sign(actSign)
                .build();

        activityService.insertSelective(activity);

        Long activityId = activity.getId();

        // 存证
        Map<String, Object> actChainMap = new HashMap<>();
        actChainMap.put(ChainConstants.ACTIVITY_DESC, desc);
        actChainMap.put(ChainConstants.ACTIVITY_THEME, theme);
        actChainMap.put(ChainConstants.ACTIVITY_START_TIME, startTimeInStr);
        actChainMap.put(ChainConstants.ACTIVITY_END_TIME, endTimeInStr);
        String actWriteChainStr = GsonUtils.toJsonString(actChainMap);
        String actCertCode = certService.writeChain(ChainConstants.ADMIN_ID, MetaActivity.TABLE_NAME, activityId,
                actSign, actWriteChainStr);
        activity.setCertCode(actCertCode);
        activity.setLastModifyTime(new Date());
        activityService.updateByPrimaryKeySelective(activity);

        activityPlanReqs.forEach((ActivityPlanReq req) -> {
            String actPlanDesc = req.getDescription();
            Byte type = req.getType();
            String unit = req.getUnit();
            Long quantity = req.getQuantity();
            String name = req.getName();
            Long amount = req.getAmount();
            String actPlanSign = SignUtils.sign(activityId, actPlanDesc, type, unit, quantity, name, amount);
            ActivityPlan plan = ActivityPlan.newBuilder()
                    .activityId(activityId)
                    .description(actPlanDesc)
                    .type(type)
                    .unit(unit)
                    .quantity(quantity)
                    .name(name)
                    .amount(amount)
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .sign(actPlanSign)
                    .build();
            activityPlanService.insertSelective(plan);
            Long planId = plan.getId();

            Map<String, Object> actPlanChainMap = new HashMap<>();
            actPlanChainMap.put(ChainConstants.ACTIVITY_ID, activityId);
            actPlanChainMap.put(ChainConstants.ACTIVITY_PLAN_DESC, actPlanDesc);
            actPlanChainMap.put(ChainConstants.ACTIVITY_PLAN_TYPE, type);
            actPlanChainMap.put(ChainConstants.ACTIVITY_PLAN_UNIT, unit);
            actPlanChainMap.put(ChainConstants.ACTIVITY_PLAN_QUANTITY, quantity);
            actPlanChainMap.put(ChainConstants.ACTIVITY_PLAN_NAME, name);
            actPlanChainMap.put(ChainConstants.ACTIVITY_PLAN_AMOUNT, amount);
            String writeChainStr = GsonUtils.toJsonString(actPlanChainMap);
            String actPlanCertCode = certService.writeChain(ChainConstants.ADMIN_ID, MetaActivityPlan.TABLE_NAME, planId,
                    actPlanSign, writeChainStr);
            plan.setCertCode(actPlanCertCode);
            plan.setLastModifyTime(new Date());
            activityPlanService.updateByPrimaryKeySelective(plan);

            List<ActivityPlanConfigReq> configs = req.getConfigs();
            if (!CollectionUtils.isEmpty(configs)) {
                for (ActivityPlanConfigReq config : configs) {
                    Integer confAmount = config.getAmount();
                    Byte donatoryLevel = config.getDonatoryLevel();
                    Long confQuantity = config.getQuantity();

                    activityPlanConfigService.insertSelective(ActivityPlanConfig.newBuilder()
                            .activityId(activityId)
                            .amount(confAmount)
                            .donatoryLevel(donatoryLevel)
                            .quantity(confQuantity)
                            .activityPlanId(planId)
                            .createTime(new Date())
                            .lastModifyTime(new Date())
                            .build());
                }
            }

        });

        return R.ok(activity.getId());
    }

    @GetMapping("/query")
    public R<Pagination<ActivityResp>> getActivities(@RequestParam(defaultValue = "1") Integer pageNo,
                                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        int start = (pageNo - 1) * pageSize;

        Set<Long> actIds = new HashSet<>();
        Pagination<ActivityResp> activityPagination = activityService.pagination(ActivityExample.newBuilder()
                        .orderByClause("id desc")
                        .start(start)
                        .limit(pageSize)
                        .build(),
                act -> {
                    Long actId = act.getId();
                    actIds.add(actId);
                    ActivityResp actRep = ActivityResp.builder()
                            .id(actId)
                            .theme(act.getTheme())
                            .description(act.getDescription())
                            .startTime(act.getStartTime())
                            .endTime(act.getEndTime())
                            .status(act.getStatus())
                            .build();
                    return actRep;
                }
        );

        return R.ok(activityPagination);
    }

    @GetMapping("/detail/{actId}")
    public R<ActivityDetailResp> detail(@PathVariable("actId") Long actId) {
        ActivityDetailResp detail = activityService.selectByPrimaryKey(
                actId,
                act -> ActivityDetailResp.builder()
                        .id(actId)
                        .theme(act.getTheme())
                        .description(act.getDescription())
                        .startTime(act.getStartTime())
                        .endTime(act.getEndTime())
                        .status(act.getStatus())
                        .build()
        );

        Set<Long> planIds = new HashSet<>();
        List<ActivityPlanDetailResp> plans = activityPlanService.selectByExample(ActivityPlanExample.newBuilder()
                .build()
                .createCriteria()
                .andActivityIdEqualTo(actId)
                .toExample(),
                item -> {
                    planIds.add(item.getId());
                    ActivityPlanDetailResp res = ActivityPlanDetailResp.builder()
                            .activityId(actId)
                            .amount(item.getAmount())
                            .description(item.getDescription())
                            .id(item.getId())
                            .name(item.getName())
                            .needPurchase(item.getNeedPurchase())
                            .quantity(item.getQuantity())
                            .type(item.getType())
                            .unit(item.getUnit())
                            .build();
                    return res;
                }
        );
        detail.setPlans(plans);

        Map<Long, List<ActivityPlanConfigResp>> configMap =
                activityPlanConfigService.selectMapListByExample(ActivityPlanConfigExample.newBuilder()
                                .build()
                                .createCriteria()
                                .andActivityPlanIdIn(planIds)
                                .toExample(),
                        ActivityPlanConfig :: getActivityPlanId,
                        item -> {
                            long mounted = assignService.countByExample(
                                    AssignExample.newBuilder().build().createCriteria().andConfigIdEqualTo(item.getId())
                                            .toExample());
                            ActivityPlanConfigResp conf = ActivityPlanConfigResp.builder()
                                    .configId(item.getId())
                                    .amount(item.getAmount())
                                    .donatoryLevel(item.getDonatoryLevel())
                                    .quantity(item.getQuantity())
                                    .mounted(mounted)
                                    .build();
                            return conf;
                        }
                );

        for (ActivityPlanDetailResp plan : plans) {
            plan.setConfigs(configMap.get(plan.getId()));
        }

        return R.ok(detail);
    }

}
