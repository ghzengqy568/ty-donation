package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawRecordDetail;
import com.baidu.mapp.bcd.domain.DrawRecordDetailExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrawRecordDetailMapper extends BaseMapper<DrawRecordDetail, Long, DrawRecordDetailExample> {
}