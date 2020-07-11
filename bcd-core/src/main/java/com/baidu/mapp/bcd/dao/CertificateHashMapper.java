package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.CertificateHash;
import com.baidu.mapp.bcd.domain.CertificateHashExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateHashMapper extends BaseMapper<CertificateHash, Long, CertificateHashExample> {
}