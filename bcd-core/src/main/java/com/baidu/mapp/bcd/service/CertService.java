/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Certificate;
import com.baidu.mapp.bcd.domain.CertificateExample;
import com.baidu.mapp.bcd.domain.dto.WasmContractDto;
import com.baidu.mapp.bcd.domain.meta.MetaCertificate;

@Service
public class CertService implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(CertService.class);

    @Value("${chain.service.url:http://122.112.158.98:8119/donate}")
    private String chainServiceUrl;

    @Value("${chain.account:donor}")
    private String account;

    @Autowired
    CertificateService certificateService;

    @Autowired
    Digest digest;

    @Autowired
    RestTemplate restTemplate;

    private URI uri = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        uri = new URL(chainServiceUrl).toURI();
    }

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
        String certCode = chain(userId, tableName.concat(":").concat(id.toString()), sign, null);
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

    public String writeChain(Long userId, String tableName, Long id, String sign, String content) {
        // 上链并返回证书
        String certCode = chain(userId, tableName.concat(":").concat(id.toString()), sign, content);
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
        String result = null;
        Certificate certificate = certificateService.selectOneByExample(CertificateExample.newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(certCode)
                .toExample(),
                MetaCertificate.COLUMN_NAME_SOURCETABLE,
                MetaCertificate.COLUMN_NAME_SOURCEID
        );

        if (certificate == null) {
            LOGGER.info("certCode[{}] has not exists in t_certificate", certCode);
            return null;
        }

        String hashId = certificate.getSourceTable().concat(":")+certificate.getSourceId();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        WasmContractDto dto = new WasmContractDto();
        dto.setAccount(account);
        dto.setSubUri(WasmContractDto.QUERY_DONOR_BY_HASH_SUBURI);
        dto.setHashId(hashId);
        RequestEntity<String> httpEntity = new RequestEntity<>(GsonUtils.toJsonString(dto), headers, HttpMethod.POST,
                uri);
        ResponseEntity<String> ent =
                restTemplate.exchange(httpEntity, ParameterizedTypeReference.forType(String.class));
        if (ent != null && ent.getStatusCode().equals(HttpStatus.OK)) {
            result = ent.getBody();
        }
        return result;
    }

    /**
     * 实际上链操作, 通过调用GO服务上链
     * @param userId 操作员/捐赠人/受赠人ID
     * @param hashId
     * @param fileName
     * @return
     */
    private String chain(Long userId, String hashId, String fileName, String content) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            content = digest.encryptDes(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fileName = fileName.concat(":").concat(content);
        WasmContractDto dto = new WasmContractDto();
        dto.setAccount(account);
        dto.setSubUri(WasmContractDto.DONATE_SUBURI);
        dto.setHashId(hashId);
        dto.setFileName(fileName);
        dto.setUserId(userId);
        RequestEntity<String> httpEntity = new RequestEntity<>(GsonUtils.toJsonString(dto), headers, HttpMethod.POST,
                uri);
        String result = null;
        ResponseEntity<String> ent =
                restTemplate.exchange(httpEntity, ParameterizedTypeReference.forType(String.class));
        if (ent != null && ent.getStatusCode().equals(HttpStatus.OK)) {
            result = ent.getBody();
        }
        return result;
    }
}
