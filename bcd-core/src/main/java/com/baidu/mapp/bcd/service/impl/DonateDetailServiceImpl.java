package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DonateDetailMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DonateDetail;
import com.baidu.mapp.bcd.domain.DonateDetailExample;
import com.baidu.mapp.bcd.service.DonateDetailService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("donateDetailService")
public class DonateDetailServiceImpl extends GenericServiceImpl<DonateDetail, Long, DonateDetailExample> implements DonateDetailService {

    @Autowired
    private DonateDetailMapper donateDetailMapper;

    @Override
    public BaseMapper<DonateDetail, Long, DonateDetailExample> getMapper() {
        return donateDetailMapper;
    }

    @Override
    public DonateDetailExample newExample() {
        return DonateDetailExample.newBuilder().build();
    }

    @Override
    public DonateDetailExample newIdInExample(List<Long> ids) {
        return DonateDetailExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }

    @Override
    public Long sumMoneyBalanceByExample(DonateDetailExample example) {
        return donateDetailMapper.sumMoneyBalanceByExample(example);
    }
}
