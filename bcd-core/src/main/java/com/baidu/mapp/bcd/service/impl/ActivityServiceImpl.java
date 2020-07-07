package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.ActivityMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityExample;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activityService")
public class ActivityServiceImpl extends GenericServiceImpl<Activity, Long, ActivityExample> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public BaseMapper<Activity, Long, ActivityExample> getMapper() {
        return activityMapper;
    }

    @Override
    public ActivityExample newExample() {
        return ActivityExample.newBuilder().build();
    }

    @Override
    public ActivityExample newIdInExample(List<Long> ids) {
        return ActivityExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}