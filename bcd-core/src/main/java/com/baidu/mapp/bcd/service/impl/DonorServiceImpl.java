package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DonorMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.service.DonorService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("donorService")
public class DonorServiceImpl extends GenericServiceImpl<Donor, Long, DonorExample> implements DonorService {

    @Autowired
    private DonorMapper donorMapper;

    @Override
    public BaseMapper<Donor, Long, DonorExample> getMapper() {
        return donorMapper;
    }

    @Override
    public DonorExample newExample() {
        return DonorExample.newBuilder().build();
    }

    @Override
    public DonorExample newIdInExample(List<Long> ids) {
        return DonorExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}