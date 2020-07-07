package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DonatoryMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DonatoryExample;
import com.baidu.mapp.bcd.service.DonatoryService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("donatoryService")
public class DonatoryServiceImpl extends GenericServiceImpl<Donatory, Long, DonatoryExample> implements DonatoryService {

    @Autowired
    private DonatoryMapper donatoryMapper;

    @Override
    public BaseMapper<Donatory, Long, DonatoryExample> getMapper() {
        return donatoryMapper;
    }

    @Override
    public DonatoryExample newExample() {
        return DonatoryExample.newBuilder().build();
    }

    @Override
    public DonatoryExample newIdInExample(List<Long> ids) {
        return DonatoryExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}