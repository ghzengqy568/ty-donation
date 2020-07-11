package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Assign;
import com.baidu.mapp.bcd.domain.AssignExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssignMapper extends BaseMapper<Assign, Long, AssignExample> {
}