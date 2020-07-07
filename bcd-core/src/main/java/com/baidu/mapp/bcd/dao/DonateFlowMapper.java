package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DonateFlow;
import com.baidu.mapp.bcd.domain.DonateFlowExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonateFlowMapper extends BaseMapper<DonateFlow, Long, DonateFlowExample> {
}