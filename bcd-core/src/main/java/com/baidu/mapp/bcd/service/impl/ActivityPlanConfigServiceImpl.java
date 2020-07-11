package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.ActivityPlanConfigMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.ActivityPlanConfig;
import com.baidu.mapp.bcd.domain.ActivityPlanConfigExample;
import com.baidu.mapp.bcd.service.ActivityPlanConfigService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activityPlanConfigService")
public class ActivityPlanConfigServiceImpl extends GenericServiceImpl<ActivityPlanConfig, Long, ActivityPlanConfigExample> implements ActivityPlanConfigService {

    @Autowired
    private ActivityPlanConfigMapper activityPlanConfigMapper;

    @Override
    public BaseMapper<ActivityPlanConfig, Long, ActivityPlanConfigExample> getMapper() {
        return activityPlanConfigMapper;
    }

    @Override
    public ActivityPlanConfigExample newExample() {
        return ActivityPlanConfigExample.newBuilder().build();
    }

    @Override
    public ActivityPlanConfigExample newIdInExample(List<Long> ids) {
        return ActivityPlanConfigExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}