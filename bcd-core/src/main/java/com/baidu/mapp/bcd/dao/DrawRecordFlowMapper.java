package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.DrawRecordFlowExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawRecordFlowMapper extends BaseMapper<DrawRecordFlow, Long, DrawRecordFlowExample> {
}