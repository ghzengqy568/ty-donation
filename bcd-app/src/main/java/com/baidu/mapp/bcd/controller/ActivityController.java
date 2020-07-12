/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityExample;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanConfig;
import com.baidu.mapp.bcd.domain.ActivityPlanConfigExample;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import com.baidu.mapp.bcd.domain.AssignExample;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.dto.ActivityDetailResp;
import com.baidu.mapp.bcd.dto.ActivityPlanConfigReq;
import com.baidu.mapp.bcd.dto.ActivityPlanConfigResp;
import com.baidu.mapp.bcd.dto.ActivityPlanDetailResp;
import com.baidu.mapp.bcd.dto.ActivityPlanReq;
import com.baidu.mapp.bcd.dto.ActivityPlanResp;
import com.baidu.mapp.bcd.dto.ActivityReq;
import com.baidu.mapp.bcd.dto.ActivityResp;
import com.baidu.mapp.bcd.service.ActivityPlanConfigService;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.AssignService;

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

    @PostMapping("/create")
    public R createActive(@RequestBody ActivityReq act) {

        List<ActivityPlanReq> activityPlanReqs = act.getActivityPlanReqList();
        if (CollectionUtils.isEmpty(activityPlanReqs)) {
            return R.error(100200, "请填写活动计划详情");
        }

        Activity activity = Activity.newBuilder()
                //                .certCode("123")
                .description(act.getDescription())
                .createTime(new Date())
                .endTime(new Date())
                //                .sign("123")
                .lastModifyTime(new Date())
                .startTime(act.getStartTime())
                .endTime(act.getEndTime())
                .theme(act.getTheme())
                .build();

        activityService.insertSelective(activity);

        Long activityId = activity.getId();
        activityPlanReqs.forEach((ActivityPlanReq req) -> {
            ActivityPlan plan = ActivityPlan.newBuilder()
                    .activityId(activityId)
                    .description(req.getDescription())
                    .type(req.getType())
                    .unit(req.getUnit())
                    .quantity(req.getQuantity())
                    .name(req.getName())
                    .amount(req.getAmount())
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .build();
            activityPlanService.insertSelective(plan);

            Long planId = plan.getId();
            List<ActivityPlanConfigReq> configs = req.getConfigs();
            if (!CollectionUtils.isEmpty(configs)) {
                for (ActivityPlanConfigReq config : configs) {
                    Integer amount = config.getAmount();
                    Byte donatoryLevel = config.getDonatoryLevel();
                    Long quantity = config.getQuantity();

                    activityPlanConfigService.insertSelective(ActivityPlanConfig.newBuilder()
                            .activityId(activityId)
                            .amount(amount)
                            .donatoryLevel(donatoryLevel)
                            .quantity(quantity)
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
                            .build();
                    return actRep;
                }
        );

        if (activityPagination.getTotal() == 0 || actIds.isEmpty()) {
            return R.ok(activityPagination);
        }

        Map<Long, List<ActivityPlanResp>> actPlanMap =
                activityPlanService.selectMapListByExample(ActivityPlanExample.newBuilder()
                                .build()
                                .createCriteria()
                                .andActivityIdIn(actIds)
                                .toExample(),
                        ActivityPlan :: getActivityId,
                        item -> {
                            ActivityPlanResp planResp = ActivityPlanResp.builder()
                                    .id(item.getId())
                                    .activityId(item.getActivityId())
                                    .type(item.getType())
                                    .unit(item.getUnit())
                                    .quantity(item.getQuantity())
                                    .name(item.getName())
                                    .amount(item.getAmount())
                                    .build();

                            return planResp;
                        }
                );

        activityPagination.each(activityResp -> {
            Long actId = activityResp.getId();
            List<ActivityPlanResp> activityPlanResps = actPlanMap.get(actId);
            activityResp.setActivityPlanRespList(activityPlanResps);
        });
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
