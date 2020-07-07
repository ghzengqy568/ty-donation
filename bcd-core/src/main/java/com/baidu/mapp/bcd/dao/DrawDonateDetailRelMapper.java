package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawDonateDetailRel;
import com.baidu.mapp.bcd.domain.DrawDonateDetailRelExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawDonateDetailRelMapper extends BaseMapper<DrawDonateDetailRel, Long, DrawDonateDetailRelExample> {
}