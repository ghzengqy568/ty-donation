package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.AssignMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Assign;
import com.baidu.mapp.bcd.domain.AssignExample;
import com.baidu.mapp.bcd.service.AssignService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("assignService")
public class AssignServiceImpl extends GenericServiceImpl<Assign, Long, AssignExample> implements AssignService {

    @Autowired
    private AssignMapper assignMapper;

    @Override
    public BaseMapper<Assign, Long, AssignExample> getMapper() {
        return assignMapper;
    }

    @Override
    public AssignExample newExample() {
        return AssignExample.newBuilder().build();
    }

    @Override
    public AssignExample newIdInExample(List<Long> ids) {
        return AssignExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}