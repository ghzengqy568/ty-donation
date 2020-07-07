package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityPlanMapper extends BaseMapper<ActivityPlan, Long, ActivityPlanExample> {
}