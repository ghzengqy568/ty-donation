package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Certificate;
import com.baidu.mapp.bcd.domain.CertificateExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateMapper extends BaseMapper<Certificate, Long, CertificateExample> {
}