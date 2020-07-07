package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.CertificateMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Certificate;
import com.baidu.mapp.bcd.domain.CertificateExample;
import com.baidu.mapp.bcd.service.CertificateService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("certificateService")
public class CertificateServiceImpl extends GenericServiceImpl<Certificate, Long, CertificateExample> implements CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;

    @Override
    public BaseMapper<Certificate, Long, CertificateExample> getMapper() {
        return certificateMapper;
    }

    @Override
    public CertificateExample newExample() {
        return CertificateExample.newBuilder().build();
    }

    @Override
    public CertificateExample newIdInExample(List<Long> ids) {
        return CertificateExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}