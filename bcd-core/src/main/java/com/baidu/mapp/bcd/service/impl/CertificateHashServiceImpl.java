package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.CertificateHashMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.CertificateHash;
import com.baidu.mapp.bcd.domain.CertificateHashExample;
import com.baidu.mapp.bcd.service.CertificateHashService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("certificateHashService")
public class CertificateHashServiceImpl extends GenericServiceImpl<CertificateHash, Long, CertificateHashExample> implements CertificateHashService {

    @Autowired
    private CertificateHashMapper certificateHashMapper;

    @Override
    public BaseMapper<CertificateHash, Long, CertificateHashExample> getMapper() {
        return certificateHashMapper;
    }

    @Override
    public CertificateHashExample newExample() {
        return CertificateHashExample.newBuilder().build();
    }

    @Override
    public CertificateHashExample newIdInExample(List<Long> ids) {
        return CertificateHashExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}