/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.*;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        Long donorId = donateReq.getDonorId();
        if (donorId == null || donorId <=0 ) {
            return R.error(100101, "捐赠人Id不能为空");
        }
        if (CollectionUtils.isEmpty(donateReq.getDetails())) {
            return R.error(100101, "捐赠明细不能为空");
        }
        Donor donor = donorService.selectByPrimaryKey(donorId);
        if (donor == null) {
            return R.error(100102, "捐赠人不存在");
        }

        // 装载UUID
        Date donateTime = new Date();
        // 流水签名 donorId, donorTime
        String sign = SignUtils.sign(donorId, DateTimeUtils.toDateTimeString(donateTime, "yyyyMMddHHmmss"));
        DonateFlow flow = DonateFlow.newBuilder()
                .donorId(donorId)
                .donateTime(donateTime)
                .certCode("")
                .sign(sign)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .build();
        donateFlowService.insertSelective(flow);
        Long flowId = flow.getId();
        String certCode = certService.writeChain(donorId, MetaDonateFlow.TABLE_NAME, flowId, sign);
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
            sign = SignUtils.sign(donorId, name, quantity, type, unit);

            DonateDetail donateDetail = DonateDetail.newBuilder()
                    .certCode("")
                    .flowId(flowId)
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .name(name)
                    .quantity(quantity)
                    .balance(quantity)
                    .sign(sign)
                    .type(type)
                    .unit(unit)
                    .build();

            donateDetailService.insertSelective(donateDetail);
            Long detailId = donateDetail.getId();
            String detailCertCode = certService.writeChain(donorId, MetaDonateDetail.TABLE_NAME, detailId, sign);
            donateDetail.setCertCode(detailCertCode);
            donateDetail.setLastModifyTime(new Date());
            donateDetailService.updateByPrimaryKeySelective(donateDetail);
        }
        return R.ok(certCode);
    }

    @GetMapping("/fetch")
    public R fetchDonationDetail(@RequestParam String certCode) {
        Certificate certificate = certService.queryCert(certCode);
        // 验证证书记录是否存在
        if (Objects.isNull(certificate)) {
            return R.error(100201, "该证书号不存在");
        }

        String sourceTable = certificate.getSourceTable();
        Long sourceId = certificate.getSourceId();
        // 捐赠人通过捐赠流水证书查询
        if (sourceTable.equalsIgnoreCase(MetaDonateFlow.TABLE_NAME)) {
            // sourceId 捐赠流水ID
            DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(sourceId);
            if (Objects.isNull(donateFlow)) {
                return R.error(100202, "该笔捐赠流水不存在");
            }

            String donateFlowCertCode = donateFlow.getCertCode();
            Long donorId = donateFlow.getDonorId();
            Date donateTime = donateFlow.getDonateTime();
            String donateFlowSign = donateFlow.getSign();

            String donateFlowSignToCmp = SignUtils.sign(donorId, DateTimeUtils.toDateTimeString(donateTime,
                    "yyyyMMddHHmmss"));
            // 验证签名1：本地库中存储的签名验证
            if (!donateFlowSignToCmp.equalsIgnoreCase(donateFlowSign)) {
                return R.error(100202, "该笔捐赠流水签名验证失败");
            }
            // 通过证书查询链上实际存储数据
            String donateFlowSignOnChain = certService.readChain(certCode);
            // 签名验证2：本地库中存储的签名验证 及 链上读取的数据签名 对比
            if (!donateFlowSign.equals(donateFlowSignOnChain)) {
                return R.error(100202, "该笔捐赠流水签名验证失败");
            }

            // 签名验证通过


        }

        return R.ok();
    }


}
