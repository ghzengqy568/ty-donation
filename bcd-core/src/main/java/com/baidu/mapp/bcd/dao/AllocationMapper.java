package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Allocation;
import com.baidu.mapp.bcd.domain.AllocationExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllocationMapper extends BaseMapper<Allocation, Long, AllocationExample> {
}