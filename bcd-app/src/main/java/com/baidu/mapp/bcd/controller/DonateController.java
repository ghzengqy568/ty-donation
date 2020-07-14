/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.*;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateDetail;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecord;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateFlowResp;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.dto.DonationFlowBriefResp;
import com.baidu.mapp.bcd.service.*;
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
    AllocationService allocationService;

    @Autowired
    CertService certService;

    @Autowired
    DrawRecordFlowService drawRecordFlowService;

    @Autowired
    DrawRecordDetailService drawRecordDetailService;

    @Autowired
    DrawRecordService drawRecordService;

    @Autowired
    DonatoryService donatoryService;

    public static final String PARTICIPATION_DONATE = "捐赠";

    public static final String PARTICIPATION_RECEIVE = "受捐";

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

    @GetMapping("/allDonations")
    public R<Pagination<DonationFlowBriefResp>> getAllDonations(@RequestParam(defaultValue = "1") Integer pageNo,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) {

        int start = (pageNo - 1) * pageSize;

        Pagination<DonationFlowBriefResp> pagination =
                donateDetailService.pagination(DonateDetailExample.newBuilder().start(start).limit(pageSize).build(),
                        donateDetail -> {
                            Long donateFlowId = donateDetail.getFlowId();
                            DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(donateFlowId);
                            Long donorId = donateFlow.getDonorId();
                            Donor donor = donorService.selectByPrimaryKey(donorId);
                            String donorName = donor.getDonorName();
                            return DonationFlowBriefResp.builder()
                                    .donorName(donorName)
                                    .donateTime(donateFlow.getDonateTime())
                                    .participation(PARTICIPATION_DONATE)
                                    .type(donateDetail.getType())
                                    .unit(donateDetail.getUnit())
                                    .quantity(donateDetail.getQuantity())
                                    .name(donateDetail.getName())
                                    .build();

                        });
        return R.ok(pagination);
    }

    @GetMapping("/genericSearch")
    public R<List<DonationFlowBriefResp>> genericSearch(@RequestParam String query) {
        // 先精准匹配证书号
        Certificate certificate = certService.queryCert(query);
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
                Donor donor = donorService.selectByPrimaryKey(donateFlow.getDonorId());
                String donorName = donor.getDonorName();
                Date donateTime = donateFlow.getDonateTime();
                List<DonationFlowBriefResp> donateDetails =
                        donateDetailService.selectByExample(DonateDetailExample.newBuilder().build()
                                .createCriteria()
                                .andFlowIdEqualTo(sourceId)
                                .toExample(), item -> {
                            return DonationFlowBriefResp.builder()
                                    .donorName(donorName)
                                    .donateTime(donateTime)
                                    .certCode(donateFlow.getCertCode())
                                    .participation(PARTICIPATION_DONATE)
                                    .type(item.getType())
                                    .unit(item.getUnit())
                                    .quantity(item.getQuantity())
                                    .name(item.getName())
                                    .build();
                        });
                return R.ok(donateDetails);
            } else if (sourceTable.equalsIgnoreCase(MetaDrawRecord.TABLE_NAME)) {
                // 受捐人通过领取记录证书查询
                // sourceId 领取流水ID
                DrawRecordFlow drawRecordFlow = drawRecordFlowService.selectByPrimaryKey(sourceId);
                Long donatoryId = drawRecordFlow.getDonatoryId();
                Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);

                List<DonationFlowBriefResp> drawRecords = drawRecordService.selectByExample(DrawRecordExample.newBuilder().build()
                        .createCriteria()
                        .andDrawRecordFlowIdEqualTo(sourceId)
                        .toExample(), item -> {
                    return DonationFlowBriefResp.builder()
                            .donorName(donatory.getDonatoryName())
                            .donateTime(drawRecordFlow.getDrawTime())
                            .certCode(drawRecordFlow.getCertCode())
                            .participation(PARTICIPATION_RECEIVE)
                            .type(item.getType())
                            .unit(item.getUnit())
                            .quantity(item.getQuantity())
                            .name(item.getName())
                            .build();
                });
                return R.ok(drawRecords);
            } else {
                return R.ok();
            }
        } else {
            // 模糊匹配捐赠人/受捐人名称
            List<DonationFlowBriefResp> flowBriefResps = Lists.newArrayList();
            // 模糊匹配捐赠人
            flowBriefResps.addAll(queryDonationsByDonar(query));
            // 模糊匹配受捐人
            flowBriefResps.addAll(queryDrawRecordsByDonatory(query));
            return R.ok(flowBriefResps);
        }
    }


    /**
     * 按模糊匹配捐赠人名称, 查询捐赠记录
     */
    private List<DonationFlowBriefResp> queryDonationsByDonar(String queryString) {
        Map<Long, Donor> donorIdMap = donorService.selectMapByExample(DonorExample.newBuilder()
                .build()
                .createCriteria()
                .andDonorNameLikeBoth(queryString)
                .toExample(), Donor::getId);
        if (CollectionUtils.isEmpty(donorIdMap)) {
            return Lists.newArrayList();
        }

        Set<Long> donorIds = donorIdMap.keySet();

        List<DonationFlowBriefResp> donateFlowResps = Lists.newArrayList();
        List<DonateFlow> donateFlows = donateFlowService.selectByExample(DonateFlowExample.newBuilder()
                .build()
                .createCriteria()
                .andDonorIdIn(donorIds)
                .toExample());
        if (!CollectionUtils.isEmpty(donateFlows)) {
            donateFlows.forEach(df -> {
                List<DonateDetail> donateDetails =
                        donateDetailService.selectByExample(DonateDetailExample.newBuilder().build()
                                .createCriteria()
                                .andFlowIdEqualTo(df.getId())
                                .toExample());
                if (!CollectionUtils.isEmpty(donateDetails)) {
                    donateDetails.forEach(item -> {
                        donateFlowResps.add(DonationFlowBriefResp.builder()
                                .donateTime(df.getDonateTime())
                                .donorName(donorIdMap.get(df.getDonorId()).getDonorName())
                                .certCode(df.getCertCode())
                                .participation(PARTICIPATION_DONATE)
                                .type(item.getType())
                                .unit(item.getUnit())
                                .quantity(item.getQuantity())
                                .name(item.getName())
                                .build());
                    });
                }
            });
        }
        return donateFlowResps;
    }

    /**
     * 按模糊匹配受捐人名称, 查询领取记录
     */
    private List<DonationFlowBriefResp> queryDrawRecordsByDonatory(String queryString) {
        Map<Long, Donatory> donatoryIdMap = donatoryService.selectMapByExample(DonatoryExample.newBuilder()
                .build()
                .createCriteria()
                .andDonatoryNameLikeBoth(queryString)
                .toExample(), Donatory::getId);
        if (CollectionUtils.isEmpty(donatoryIdMap)) {
            return Lists.newArrayList();
        }

        Set<Long> donatoryIds = donatoryIdMap.keySet();

        List<DonationFlowBriefResp> donateFlowResps = Lists.newArrayList();
        List<DrawRecordFlow> drawRecordFlows = drawRecordFlowService.selectByExample(DrawRecordFlowExample.newBuilder()
                .build()
                .createCriteria()
                .andDonatoryIdIn(donatoryIds)
                .toExample());
        if (!CollectionUtils.isEmpty(drawRecordFlows)) {
            drawRecordFlows.forEach(drawRecordFlow -> {
                List<DrawRecord> drawRecords =
                        drawRecordService.selectByExample(DrawRecordExample.newBuilder().build()
                                .createCriteria()
                                .andDrawRecordFlowIdEqualTo(drawRecordFlow.getId())
                                .toExample());
                if (!CollectionUtils.isEmpty(drawRecords)) {
                    drawRecords.forEach(item -> {
                        donateFlowResps.add(DonationFlowBriefResp.builder()
                                .donateTime(drawRecordFlow.getDrawTime())
                                .donorName(donatoryIdMap.get(drawRecordFlow.getDonatoryId()).getDonatoryName())
                                .certCode(drawRecordFlow.getCertCode())
                                .participation(PARTICIPATION_RECEIVE)
                                .type(item.getType())
                                .unit(item.getUnit())
                                .quantity(item.getQuantity())
                                .name(item.getName())
                                .build());
                    });
                }
            });
        }
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
