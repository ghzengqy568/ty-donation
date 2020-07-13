/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service;

import java.util.Date;
import java.util.UUID;

import com.baidu.mapp.bcd.domain.CertificateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapp.bcd.domain.Certificate;

@Service
public class CertService {

    @Autowired
    CertificateService certificateService;

    /**
     * @param userId,   流水+详情 -> 捐赠人ID，
     *                  领取记录 -> 受捐人ID
     *                  活动，计划，拨款 —> 操作人ID
     * @param tableName
     * @param id
     * @param sign
     *
     * @return
     */
    public String writeChain(Long userId, String tableName, Long id, String sign) {
        // 上链并返回证书
        String certCode = chain(userId, tableName.concat(":").concat(id.toString()), sign);
        // 记录存证表
        certificateService.insertSelective(Certificate.newBuilder()
                .certCode(certCode)
                .certTime(new Date())
                .lastModifyTime(new Date())
                .createTime(new Date())
                .sourceId(id)
                .sourceTable(tableName)
                .build());
        // 返回证书
        return certCode;
    }

    /**
     * 通过证书号查询本地DB中证书记录
     * @param certCode 被查询的证书号
     * @return 本地DB中存储的证书记录
     */
    public Certificate queryCert(String certCode) {
        return certificateService.selectOneByExample(CertificateExample
                .newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(certCode)
                .toExample());
    }

    /**
     * 通过证书号查询链上存储的内容
     * @param certCode 被查询的链上证书号
     * @return 返回对应的链上内容, 即sign
     */
    public String readChain(String certCode) {
        //
        return unchain(certCode);
    }

    /**
     * 实际上链操作, 通过调用GO服务上链
     * @param userId 操作员/捐赠人/受赠人ID
     * @param hashId
     * @param fileName
     * @return
     */
    private String chain(Long userId, String hashId, String fileName) {
        // TODO 调用GO服务上链
        return UUID.randomUUID().toString();
    }

    private String unchain(String certCode) {
        // TODO 调用GO服务查询链上数据
        return UUID.randomUUID().toString();
    }
}
