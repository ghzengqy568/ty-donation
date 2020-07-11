package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.ActivityPlanConfig;
import com.baidu.mapp.bcd.domain.ActivityPlanConfigExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityPlanConfigMapper extends BaseMapper<ActivityPlanConfig, Long, ActivityPlanConfigExample> {
}