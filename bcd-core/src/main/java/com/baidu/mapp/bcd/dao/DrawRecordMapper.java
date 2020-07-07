package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawRecord;
import com.baidu.mapp.bcd.domain.DrawRecordExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawRecordMapper extends BaseMapper<DrawRecord, Long, DrawRecordExample> {
}