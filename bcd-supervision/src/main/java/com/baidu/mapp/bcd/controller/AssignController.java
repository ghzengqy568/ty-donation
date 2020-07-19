/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.domain.*;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonatory;
import com.baidu.mapp.bcd.dto.AssignConfigReq;
import com.baidu.mapp.bcd.dto.AssignPlanReq;
import com.baidu.mapp.bcd.dto.AssignReq;
import com.baidu.mapp.bcd.service.*;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Schema(description = "指派关系接口", name = "AssignController")
@RestController
@RequestMapping("/assign")
public class AssignController {

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityPlanService activityPlanService;

    @Autowired
    ActivityPlanConfigService activityPlanConfigService;

    @Autowired
    DonatoryService donatoryService;

    @Autowired
    AssignService assignService;

    @PostMapping("assign")
    public R assign(@RequestHeader("X-TOKEN") String xtoken, @RequestBody AssignReq assignReq) {

        Long activityId = assignReq.getActivityId();
        if (activityId == null || activityId <= 0) {
            return R.error(100101, "活动不能为空");
        }
        Activity activity = activityService.selectByPrimaryKey(activityId);
        if (activity == null) {
            return R.error(100102, "活动不存在");
        }

        List<AssignPlanReq> plans = assignReq.getPlans();
        if (CollectionUtils.isEmpty(plans)) {
            return R.error(100101, "活动计划不能为空");
        }

        // 校验
        for (AssignPlanReq plan : plans) {

            Long planId = plan.getPlanId();
            if (planId == null || planId <= 0) {
                return R.error(100101, "活动计划ID不能为空");
            }

            List<AssignConfigReq> configs = plan.getConfigs();
            if (CollectionUtils.isEmpty(configs)) {
                return R.error(100101, "活动计划ID=" + planId + "的配置不能为空");
            }

            ActivityPlan activityPlan = activityPlanService.selectByPrimaryKey(planId);
            if (Objects.isNull(activityPlan)) {
                return R.error(100102, "活动计划ID=" + planId + "不存在");
            }

            for (AssignConfigReq config : configs) {
                Long configId = config.getConfigId();
                List<Long> donatoryIds = config.getDonatoryIds();
                if (configId == null) {
                    return R.error(100101, "活动计划ID=" + planId + "的配置不能为空");
                }
                if (CollectionUtils.isEmpty(donatoryIds)) {
                    return R.error(100101, "活动计划配置ID=" + configId + "的受捐人不能为空");
                }
                ActivityPlanConfig activityPlanConfig = activityPlanConfigService.selectByPrimaryKey(configId);
                if (activityPlanConfig == null) {
                    return R.error(100102, "活动计划ID=" + planId + "的配置不存在");
                }
                if (activityPlanConfig.getAmount() > donatoryIds.size()) {
                    return R.error(100102, "活动计划配置ID=" + configId + "的受捐人超配");
                }

                if (activityPlanConfig.getAmount() < donatoryIds.size()) {
                    return R.error(100102, "活动计划配置ID=" + configId + "的受捐人数量不足");
                }

                Byte donatoryLevel = activityPlanConfig.getDonatoryLevel();
                List<String> donatoryUserNames = donatoryService.selectByExample(DonatoryExample.newBuilder()
                                .build()
                                .createCriteria()
                                .andDonatoryLevelNotEqualTo(donatoryLevel)
                                .andIdIn(donatoryIds)
                                .toExample(),
                        Donatory :: getDonatoryUserName,
                        MetaDonatory.COLUMN_NAME_DONATORYUSERNAME
                );
                if (!CollectionUtils.isEmpty(donatoryUserNames)) {
                    return R.error(100102,
                            "活动计划配置ID=" + configId + "的受捐人" + GsonUtils.toJsonString(donatoryUserNames) + " 等级不匹配");
                }
            }
        }

        for (AssignPlanReq plan : plans) {
            Long planId = plan.getPlanId();
            List<AssignConfigReq> configs = plan.getConfigs();
            for (AssignConfigReq config : configs) {
                // 先删除
                assignService.deleteByExample(AssignExample.newBuilder()
                        .build()
                        .createCriteria()
                        .andConfigIdEqualTo(config.getConfigId())
                        .toExample()
                );
                Long configId = config.getConfigId();
                ActivityPlanConfig activityPlanConfig = activityPlanConfigService.selectByPrimaryKey(configId);
                List<Long> donatoryIds = config.getDonatoryIds();
                for (Long donatoryId : donatoryIds) {
                    assignService.insertSelective(Assign.newBuilder()
                            .activityId(activityId)
                            .activityPlanId(planId)
                            .configId(configId)
                            .donatoryId(donatoryId)
                            .donatoryLevel(activityPlanConfig.getDonatoryLevel())
                            .createTime(new Date())
                            .lastModifyTime(new Date())
                            .build()
                    );
                }
            }
        }

        // 活动状态， 0-待拨款， 1-已拨款，2-已指派，3-领取中， 4-已结束
        activity.setStatus((byte)2);
        activity.setLastModifyTime(new Date());
        activityService.updateByPrimaryKeySelective(activity);

        return R.ok();
    }




}
