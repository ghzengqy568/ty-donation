package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.PlanAllocationRelMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.PlanAllocationRel;
import com.baidu.mapp.bcd.domain.PlanAllocationRelExample;
import com.baidu.mapp.bcd.service.PlanAllocationRelService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("planAllocationRelService")
public class PlanAllocationRelServiceImpl extends GenericServiceImpl<PlanAllocationRel, Long, PlanAllocationRelExample> implements PlanAllocationRelService {

    @Autowired
    private PlanAllocationRelMapper planAllocationRelMapper;

    @Override
    public BaseMapper<PlanAllocationRel, Long, PlanAllocationRelExample> getMapper() {
        return planAllocationRelMapper;
    }

    @Override
    public PlanAllocationRelExample newExample() {
        return PlanAllocationRelExample.newBuilder().build();
    }

    @Override
    public PlanAllocationRelExample newIdInExample(List<Long> ids) {
        return PlanAllocationRelExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}