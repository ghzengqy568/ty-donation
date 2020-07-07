package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.AllocationMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Allocation;
import com.baidu.mapp.bcd.domain.AllocationExample;
import com.baidu.mapp.bcd.service.AllocationService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("allocationService")
public class AllocationServiceImpl extends GenericServiceImpl<Allocation, Long, AllocationExample> implements AllocationService {

    @Autowired
    private AllocationMapper allocationMapper;

    @Override
    public BaseMapper<Allocation, Long, AllocationExample> getMapper() {
        return allocationMapper;
    }

    @Override
    public AllocationExample newExample() {
        return AllocationExample.newBuilder().build();
    }

    @Override
    public AllocationExample newIdInExample(List<Long> ids) {
        return AllocationExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}