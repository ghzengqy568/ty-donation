/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.DonateDetail;
import com.baidu.mapp.bcd.domain.DonateDetailExample;
import com.baidu.mapp.bcd.domain.DonateFlow;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateDetail;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.dto.DonorReq;
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
        Long donorId = donateReq.getDonorId();
        if (donorId == null || donorId <= 0) {
            return R.error(100101, "捐赠人Id不能为空");
        }
        if (CollectionUtils.isEmpty(donateReq.getDetails())) {
            return R.error(100102, "捐赠明细不能为空");
        }
        Donor donor = donorService.selectByPrimaryKey(donorId);
        if (donor == null) {
            return R.error(100102, "捐赠人不存在");
        }
        Date donateTime = new Date();
        // 流水签名 donorId, donorTime
        String sign = SignUtils.sign(donateReq.getDonorId(), DateTimeUtils.toDateTimeString(donateTime,
                "yyyyMMddHHmmss"));
        DonateFlow flow = DonateFlow.newBuilder()
                .donorId(donorId)
                .donateTime(donateTime)
                .certCode("")
                .sign(sign)
                .createTime(new Date())
                .lastModifyTime(new Date())
//                TODO 填充数据
                .build();
        donateFlowService.insertSelective(flow);
        Long flowId = flow.getId();
        String certCode = certService.writeChain(donorId.toString(), MetaDonateFlow.TABLE_NAME, flowId, sign);
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
            sign = SignUtils.sign(donateReq.getDonorId(), name, quantity, type, unit);

            DonateDetail donateDetail = DonateDetail.newBuilder()
                    .certCode("")
                    .flowId(flowId)
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .name(name)
                    .quantity(quantity)
                    .sign(sign)
                    .type(type)
                    .unit(unit)
                    .build();

            donateDetailService.insertSelective(donateDetail);
            Long detailId = donateDetail.getId();
            String detailCertCode = certService.writeChain(donorId.toString(), MetaDonateDetail.TABLE_NAME, detailId,
                    sign);
            donateDetail.setCertCode(detailCertCode);
            donateDetail.setLastModifyTime(new Date());
            donateDetailService.updateByPrimaryKeySelective(donateDetail);
        }
        return R.ok(certCode);
    }

}
