package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonorMapper extends BaseMapper<Donor, Long, DonorExample> {
}