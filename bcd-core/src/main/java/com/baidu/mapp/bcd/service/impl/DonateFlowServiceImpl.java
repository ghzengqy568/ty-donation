package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DonateFlowMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DonateFlow;
import com.baidu.mapp.bcd.domain.DonateFlowExample;
import com.baidu.mapp.bcd.service.DonateFlowService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("donateFlowService")
public class DonateFlowServiceImpl extends GenericServiceImpl<DonateFlow, Long, DonateFlowExample> implements DonateFlowService {

    @Autowired
    private DonateFlowMapper donateFlowMapper;

    @Override
    public BaseMapper<DonateFlow, Long, DonateFlowExample> getMapper() {
        return donateFlowMapper;
    }

    @Override
    public DonateFlowExample newExample() {
        return DonateFlowExample.newBuilder().build();
    }

    @Override
    public DonateFlowExample newIdInExample(List<Long> ids) {
        return DonateFlowExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}