package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.DrawDonateDetailRelMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DrawDonateDetailRel;
import com.baidu.mapp.bcd.domain.DrawDonateDetailRelExample;
import com.baidu.mapp.bcd.service.DrawDonateDetailRelService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("drawDonateDetailRelService")
public class DrawDonateDetailRelServiceImpl extends GenericServiceImpl<DrawDonateDetailRel, Long, DrawDonateDetailRelExample> implements DrawDonateDetailRelService {

    @Autowired
    private DrawDonateDetailRelMapper drawDonateDetailRelMapper;

    @Override
    public BaseMapper<DrawDonateDetailRel, Long, DrawDonateDetailRelExample> getMapper() {
        return drawDonateDetailRelMapper;
    }

    @Override
    public DrawDonateDetailRelExample newExample() {
        return DrawDonateDetailRelExample.newBuilder().build();
    }

    @Override
    public DrawDonateDetailRelExample newIdInExample(List<Long> ids) {
        return DrawDonateDetailRelExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}