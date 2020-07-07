package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DrawRecordMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawRecord;
import com.baidu.mapp.bcd.domain.DrawRecordExample;
import com.baidu.mapp.bcd.service.DrawRecordService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("drawRecordService")
public class DrawRecordServiceImpl extends GenericServiceImpl<DrawRecord, Long, DrawRecordExample> implements DrawRecordService {

    @Autowired
    private DrawRecordMapper drawRecordMapper;

    @Override
    public BaseMapper<DrawRecord, Long, DrawRecordExample> getMapper() {
        return drawRecordMapper;
    }

    @Override
    public DrawRecordExample newExample() {
        return DrawRecordExample.newBuilder().build();
    }

    @Override
    public DrawRecordExample newIdInExample(List<Long> ids) {
        return DrawRecordExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}