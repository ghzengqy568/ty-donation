/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Certificate;
import com.baidu.mapp.bcd.domain.CertificateExample;
import com.baidu.mapp.bcd.domain.dto.WasmContractDto;
import com.baidu.mapp.bcd.domain.meta.MetaCertificate;
import com.baidu.mapp.bcd.service.CertificateService;
import com.baidu.mapp.bcd.service.ChainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.Date;

/**
 * XuperChain 数据上链与链上数据查询
 */
@Service
public class XuperChainServiceImpl implements InitializingBean, ChainService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChainService.class);

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
     * 数据上链
     *
     * @param userId,   流水+详情 -> 捐赠人ID
     *                  领取记录 -> 受捐人ID
     *                  活动，计划，拨款 —> 操作人ID
     * @param domain 数据域
     * @param id 数据标识
     * @param sign 上链数据签名
     * @param content 上链原始数据
     * @return 链上存证地址
     */
    public String writeChain(Long userId, String domain, Long id, String sign, String content) {
        // 生成存证标识
        String identityId = domain.concat(":").concat(id.toString());
        // 上链操作
        String address = chain(userId, identityId, sign, content);
        // 记录存证关系
        certificateService.insertSelective(Certificate.newBuilder()
                .certCode(address)
                .certTime(new Date())
                .lastModifyTime(new Date())
                .createTime(new Date())
                .sourceId(id)
                .sourceTable(domain)
                .build());
        // 返回链上存证地址
        return address;
    }

    /**
     * 通过存证地址查询链上数据
     * @param address 链上存证地址
     * @return 返回对应的链上数据
     */
    public String readChain(String address) {
        String result = null;
        // 根据存证地址获取存证数据标识
        Certificate certificate = certificateService.selectOneByExample(CertificateExample.newBuilder()
                        .build()
                        .createCriteria()
                        .andCertCodeEqualTo(address)
                        .toExample(),
                MetaCertificate.COLUMN_NAME_SOURCETABLE,
                MetaCertificate.COLUMN_NAME_SOURCEID
        );

        if (certificate == null) {
            LOGGER.info("Address[{}] has not exists in t_certificate", address);
            return null;
        }

        String identityId = certificate.getSourceTable().concat(":") + certificate.getSourceId();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        WasmContractDto dto = new WasmContractDto();
        dto.setAccount(account);
        dto.setSubUri(WasmContractDto.QUERY_DONOR_BY_HASH_SUBURI);
        dto.setIdentityId(identityId);
        RequestEntity<String> httpEntity = new RequestEntity<>(GsonUtils.toJsonString(dto), headers, HttpMethod.POST,
                uri);
        // 调用GO服务查询链上数据
        ResponseEntity<String> ent =
                restTemplate.exchange(httpEntity, ParameterizedTypeReference.forType(String.class));
        if (ent != null && ent.getStatusCode().equals(HttpStatus.OK)) {
            result = ent.getBody();
        }
        return result;
    }

    /**
     * 实际上链操作, 通过调用GO服务上链
     *
     * @param userId 操作员/捐赠人/受赠人ID
     * @param identityId 存证标识
     * @param sign 上链数据签名
     * @param content 上链原始数据
     * @return 链上存证地址
     */
    private String chain(Long userId, String identityId, String sign, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            content = digest.encryptDes(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sign = sign.concat(":").concat(content);
        WasmContractDto dto = new WasmContractDto();
        dto.setAccount(account);
        dto.setSubUri(WasmContractDto.DONATE_SUBURI);
        dto.setIdentityId(identityId);
        dto.setSign(sign);
        dto.setUserId(userId);
        RequestEntity<String> httpEntity = new RequestEntity<>(GsonUtils.toJsonString(dto), headers, HttpMethod.POST,
                uri);
        String address = null;
        ResponseEntity<String> ent =
                restTemplate.exchange(httpEntity, ParameterizedTypeReference.forType(String.class));
        if (ent != null && ent.getStatusCode().equals(HttpStatus.OK)) {
            address = ent.getBody();
        }
        return address;
    }

}
