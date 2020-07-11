/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.DonateDetail;
import com.baidu.mapp.bcd.domain.DonateFlow;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateDetail;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonateDetailService;
import com.baidu.mapp.bcd.service.DonateFlowService;
import com.baidu.mapp.bcd.service.DonorService;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "捐赠接口", name = "DonateController")
@RestController
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    DonateFlowService donateFlowService;

    @Autowired
    DonateDetailService donateDetailService;

    @Autowired
    DonorService donorService;

    @Autowired
    CertService certService;

    @PostMapping("submit")
    public R<String> submit(@RequestBody DonateReq donateReq) {
        String donorId = donateReq.getDonorUuid();
        if (StringUtils.isBlank(donorId)) {
            return R.error(100101, "捐赠人Id不能为空");
        }
        if (CollectionUtils.isEmpty(donateReq.getDetails())) {
            return R.error(100101, "捐赠明细不能为空");
        }
        Donor donor =
                donorService.selectOneByExample(
                        DonorExample.newBuilder().build().createCriteria().andUuidEqualTo(donorId).toExample());
        if (donor == null) {
            return R.error(100102, "捐赠人不存在");
        }

        // 装载UUID
        donateReq.setUuid(UUID.randomUUID().toString());
        Date donateTime = new Date();
        // 流水签名 donorId, donorTime
        String sign = SignUtils.sign(donateReq.getDonorUuid(), DateTimeUtils.toDateTimeString(donateTime,
                "yyyyMMddHHmmss"));
        DonateFlow flow = DonateFlow.newBuilder()
                .donorUuid(donorId)
                .donateTime(donateTime)
                .certCode("")
                .sign(sign)
                .uuid(donateReq.getUuid())
                .createTime(new Date())
                .lastModifyTime(new Date())
                .build();
        donateFlowService.insertSelective(flow);
        String certCode = certService.writeChain(donorId, MetaDonateFlow.TABLE_NAME, donateReq.getUuid(), sign);
        flow.setCertCode(certCode);
        flow.setLastModifyTime(new Date());
        donateFlowService.updateByPrimaryKeySelective(flow);
        // details ...
        List<DonateDetailReq> details = donateReq.getDetails();
        for (DonateDetailReq detail : details) {
            String name = detail.getName();
            Long quantity = detail.getQuantity();
            Byte type = detail.getType();
            String unit = detail.getUnit();
            detail.setUuid(UUID.randomUUID().toString());
            sign = SignUtils.sign(donateReq.getDonorUuid(), name, quantity, type, unit);

            DonateDetail donateDetail = DonateDetail.newBuilder()
                    .certCode("")
                    .flowUuid(donateReq.getUuid())
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .name(name)
                    .quantity(quantity)
                    .balance(quantity)
                    .sign(sign)
                    .uuid(detail.getUuid())
                    .type(type)
                    .unit(unit)
                    .build();

            donateDetailService.insertSelective(donateDetail);
            String detailId = donateDetail.getUuid();
            String detailCertCode = certService.writeChain(donorId, MetaDonateDetail.TABLE_NAME, detailId,
                    sign);
            donateDetail.setCertCode(detailCertCode);
            donateDetail.setLastModifyTime(new Date());
            donateDetailService.updateByPrimaryKeySelective(donateDetail);
        }
        return R.ok(certCode);
    }

}
