/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service;

import java.util.Date;
import java.util.UUID;

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
     * @param uuid
     * @param sign
     *
     * @return
     */
    public String writeChain(String userId, String tableName, String uuid, String sign) {
        // 上链并返回证书
        String certCode = chain(userId, tableName.concat(":").concat(uuid), sign);
        // 记录存证表
        certificateService.insertSelective(Certificate.newBuilder()
                .certCode(certCode)
                .certTime(new Date())
                .lastModifyTime(new Date())
                .createTime(new Date())
                .uuid(uuid)
                .sourceTable(tableName)
                .build());

        // TODO 发布消息 t_certificate_hash(certCode, uuid)

        // 返回证书
        return certCode;
    }

    private String chain(String userId, String hashId, String fileName) {
        // TODO 调用GO服务上链
        return UUID.randomUUID().toString();
    }
}
