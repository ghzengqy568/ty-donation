package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DonatoryExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonatoryMapper extends BaseMapper<Donatory, Long, DonatoryExample> {
}