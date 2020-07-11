/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityExample;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.dto.ActivityPlanReq;
import com.baidu.mapp.bcd.dto.ActivityPlanResp;
import com.baidu.mapp.bcd.dto.ActivityReq;
import com.baidu.mapp.bcd.dto.ActivityResp;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityPlanService activityPlanService;

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

        String activityId = activity.getUuid();
        activityPlanReqs.forEach((ActivityPlanReq req) -> {
            ActivityPlan plan = ActivityPlan.newBuilder()
                    .activityUuid(activityId)
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
        });

        return R.ok(activity.getId());
    }

    @GetMapping("/query")
    public R<List<ActivityResp>> getActivities(@RequestParam(defaultValue = "1") Integer pageNo,
                                               @RequestParam(defaultValue = "10") Integer pageSize) {
        int start = (pageNo - 1) * pageSize;
        Pagination<Activity> activityPagination = activityService.pagination(ActivityExample.newBuilder()
                .start(start)
                .limit(pageSize)
                .build());
        if (activityPagination.getTotal() == 0) {
            return R.ok(Collections.emptyList());
        }

        List<ActivityResp> activityResps = new ArrayList<>();
        List<Activity> activities = activityPagination.getDataList();
        activities.forEach((Activity act) -> {
            Long actId = act.getId();
            String actUuid = act.getUuid();
            List<ActivityPlan> activityPlans =
                    activityPlanService.selectByExample(ActivityPlanExample.newBuilder().build().createCriteria()
                            .andActivityUuidEqualTo(actUuid).toExample());
            List<ActivityPlanResp> planResps = new ArrayList<>(activityPlans.size());
            if (!CollectionUtils.isEmpty(activityPlans)) {
                activityPlans.forEach((ActivityPlan p) -> {
                    ActivityPlanResp planResp = ActivityPlanResp.builder()
                            .id(p.getId())
                            .activityId(p.getActivityUuid())
                            .type(p.getType())
                            .unit(p.getUnit())
                            .quantity(p.getQuantity())
                            .name(p.getName())
                            .amount(p.getAmount())
                            .build();
                    planResps.add(planResp);
                });
            }

            ActivityResp actRep = ActivityResp.builder()
                    .id(actId)
                    .theme(act.getTheme())
                    .description(act.getDescription())
                    .startTime(act.getStartTime())
                    .endTime(act.getEndTime())
                    .activityPlanRespList(planResps)
                    .build();
            activityResps.add(actRep);
        });

        return R.ok(activityResps);
    }

}
