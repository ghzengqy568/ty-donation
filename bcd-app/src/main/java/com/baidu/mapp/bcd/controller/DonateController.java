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
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecord;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateFlowResp;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonateDetailService;
import com.baidu.mapp.bcd.service.DonateFlowService;
import com.baidu.mapp.bcd.service.DonorService;
import com.google.common.collect.Lists;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/genSearch")
    public R<List<DonateFlowResp>> genericSearch(@RequestParam String queryString) {
        // 先精准匹配证书号
        Certificate certificate = certService.queryCert(queryString);
        // 验证证书记录是否存在
        // 如果证书记录存在, 则查询证书对应的捐赠/受捐详情
        if (Objects.nonNull(certificate)) {
            String sourceTable = certificate.getSourceTable();
            Long sourceId = certificate.getSourceId();
            if (sourceTable.equalsIgnoreCase(MetaDonateFlow.TABLE_NAME)) {
                // 捐赠人通过捐赠流水证书查询
                // sourceId 捐赠流水ID
                DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(sourceId);
                if (Objects.isNull(donateFlow)) {
                    return R.error(100202, "该笔捐赠流水不存在");
                }
                List<DonateFlowResp> dfResps = Lists.newArrayList();
                dfResps.add(DonateFlowResp.builder()
                        .id(donateFlow.getId())
                        .donorId(donateFlow.getDonorId())
                        .donateTime(donateFlow.getDonateTime())
                        .certCode(queryString)
                        .build());
                return R.ok(dfResps);
            } else if (sourceTable.equalsIgnoreCase(MetaDrawRecord.TABLE_NAME)) {
                // 受捐人通过领取记录证书查询


                return R.ok();
            } else {
                // 其他证书类型查询, 暂不受理
                return R.ok();
            }

        } else {
            // 如果证书记录不存在, 则模糊匹配捐赠记录
            return R.ok(queryDonationsByDonar(queryString));
        }
    }

    /**
     * 按模糊匹配捐赠人名称, 查询捐赠记录
     */
    private List<DonateFlowResp> queryDonationsByDonar(String queryString) {
        Map<Long, Donor> donorIdMap = donorService.selectMapByExample(DonorExample.newBuilder()
                .build()
                .createCriteria()
                .andDonorNameLike("%" + queryString + "%")
                .toExample(), Donor::getId);
        if (CollectionUtils.isEmpty(donorIdMap)) {
            return Lists.newArrayList();
        }

        Set<Long> donorIds = donorIdMap.keySet();

        List<DonateFlowResp> donateFlowResps = donateFlowService.selectByExample(DonateFlowExample.newBuilder()
                .build()
                .createCriteria()
                .andDonorIdIn(donorIds)
                .toExample(), (DonateFlow df) -> {
            return DonateFlowResp.builder()
                    .id(df.getId())
                    .donorId(df.getDonorId())
                    .donorName(donorIdMap.get(df.getDonorId()).getDonorName())
                    .donateTime(df.getDonateTime())
                    .certCode(df.getCertCode())
                    .build();
        });
        return donateFlowResps;
    }

    /**
     * 按精确匹配证书号, 查询捐款流程
     * @param queryString
     * @return
     */
    private List<DonateFlowResp> queryDonationsByDonorCertCode(String queryString) {




        List<DonateFlow> donateFlows = donateFlowService
                .selectByExample(DonateFlowExample.newBuilder().build().createCriteria().andCertCodeEqualTo
                        (queryString).toExample());

        // todo

        return null;

    }




}
