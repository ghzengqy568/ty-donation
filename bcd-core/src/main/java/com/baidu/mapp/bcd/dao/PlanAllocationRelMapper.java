package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.PlanAllocationRel;
import com.baidu.mapp.bcd.domain.PlanAllocationRelExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanAllocationRelMapper extends BaseMapper<PlanAllocationRel, Long, PlanAllocationRelExample> {
}