package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DrawRecordDetailMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawRecordDetail;
import com.baidu.mapp.bcd.domain.DrawRecordDetailExample;
import com.baidu.mapp.bcd.service.DrawRecordDetailService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("drawRecordDetailService")
public class DrawRecordDetailServiceImpl extends GenericServiceImpl<DrawRecordDetail, Long, DrawRecordDetailExample> implements DrawRecordDetailService {

    @Autowired
    private DrawRecordDetailMapper drawRecordDetailMapper;

    @Override
    public BaseMapper<DrawRecordDetail, Long, DrawRecordDetailExample> getMapper() {
        return drawRecordDetailMapper;
    }

    @Override
    public DrawRecordDetailExample newExample() {
        return DrawRecordDetailExample.newBuilder().build();
    }

    @Override
    public DrawRecordDetailExample newIdInExample(List<Long> ids) {
        return DrawRecordDetailExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}