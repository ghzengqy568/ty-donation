package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.ActivityPlanMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activityPlanService")
public class ActivityPlanServiceImpl extends GenericServiceImpl<ActivityPlan, Long, ActivityPlanExample> implements ActivityPlanService {

    @Autowired
    private ActivityPlanMapper activityPlanMapper;

    @Override
    public BaseMapper<ActivityPlan, Long, ActivityPlanExample> getMapper() {
        return activityPlanMapper;
    }

    @Override
    public ActivityPlanExample newExample() {
        return ActivityPlanExample.newBuilder().build();
    }

    @Override
    public ActivityPlanExample newIdInExample(List<Long> ids) {
        return ActivityPlanExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}