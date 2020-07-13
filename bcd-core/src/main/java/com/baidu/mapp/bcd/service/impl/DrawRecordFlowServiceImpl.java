package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DrawRecordFlowMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.DrawRecordFlowExample;
import com.baidu.mapp.bcd.service.DrawRecordFlowService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("drawRecordFlowService")
public class DrawRecordFlowServiceImpl extends GenericServiceImpl<DrawRecordFlow, Long, DrawRecordFlowExample> implements DrawRecordFlowService {

    @Autowired
    private DrawRecordFlowMapper drawRecordFlowMapper;

    @Override
    public BaseMapper<DrawRecordFlow, Long, DrawRecordFlowExample> getMapper() {
        return drawRecordFlowMapper;
    }

    @Override
    public DrawRecordFlowExample newExample() {
        return DrawRecordFlowExample.newBuilder().build();
    }

    @Override
    public DrawRecordFlowExample newIdInExample(List<Long> ids) {
        return DrawRecordFlowExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}