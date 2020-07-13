/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.utils.ActivityStatus;
import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.*;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaActivity;
import com.baidu.mapp.bcd.domain.meta.MetaActivityPlan;
import com.baidu.mapp.bcd.dto.*;
import com.baidu.mapp.bcd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        String actCertCode = certService.writeChain(9900000L, MetaActivity.TABLE_NAME, activityId, actSign);
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
                    .type(req.getType())
                    .unit(req.getUnit())
                    .quantity(req.getQuantity())
                    .name(req.getName())
                    .amount(req.getAmount())
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .sign(actPlanSign)
                    .build();
            activityPlanService.insertSelective(plan);
            Long planId = plan.getId();

            String actPlanCertCode = certService.writeChain(9900000L, MetaActivityPlan.TABLE_NAME, planId,
                    actPlanSign);
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

    // todo 查询活动和计划的时候需不需要验证链上数据和本地数据
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
                            .status(act.getStatus())
                            .build();
                    return actRep;
                }
        );

        return R.ok(activityPagination);
//        if (activityPagination.getTotal() == 0 || actIds.isEmpty()) {
//            return R.ok(activityPagination);
//        }
//
//        Map<Long, List<ActivityPlanResp>> actPlanMap =
//                activityPlanService.selectMapListByExample(ActivityPlanExample.newBuilder()
//                                .build()
//                                .createCriteria()
//                                .andActivityIdIn(actIds)
//                                .toExample(),
//                        ActivityPlan :: getActivityId,
//                        item -> {
//                            ActivityPlanResp planResp = ActivityPlanResp.builder()
//                                    .id(item.getId())
//                                    .activityId(item.getActivityId())
//                                    .type(item.getType())
//                                    .unit(item.getUnit())
//                                    .quantity(item.getQuantity())
//                                    .name(item.getName())
//                                    .amount(item.getAmount())
//                                    .build();
//
//                            return planResp;
//                        }
//                );
//
//        activityPagination.each(activityResp -> {
//            Long actId = activityResp.getId();
//            List<ActivityPlanResp> activityPlanResps = actPlanMap.get(actId);
//            activityResp.setActivityPlanRespList(activityPlanResps);
//        });
//        return R.ok(activityPagination);
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
