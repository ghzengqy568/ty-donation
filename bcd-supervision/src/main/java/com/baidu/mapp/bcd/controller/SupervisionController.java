/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.ChainConstants;
import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.MaskUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.Allocation;
import com.baidu.mapp.bcd.domain.AllocationExample;
import com.baidu.mapp.bcd.domain.Certificate;
import com.baidu.mapp.bcd.domain.CertificateExample;
import com.baidu.mapp.bcd.domain.DonateDetail;
import com.baidu.mapp.bcd.domain.DonateDetailExample;
import com.baidu.mapp.bcd.domain.DonateFlow;
import com.baidu.mapp.bcd.domain.DonateFlowExample;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DonatoryExample;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.domain.DrawRecord;
import com.baidu.mapp.bcd.domain.DrawRecordDetail;
import com.baidu.mapp.bcd.domain.DrawRecordDetailExample;
import com.baidu.mapp.bcd.domain.DrawRecordExample;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.DrawRecordFlowExample;
import com.baidu.mapp.bcd.domain.PlanAllocationRel;
import com.baidu.mapp.bcd.domain.PlanAllocationRelExample;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
import com.baidu.mapp.bcd.dto.AllDonationFlowResp;
import com.baidu.mapp.bcd.dto.DCActivityBriefResp;
import com.baidu.mapp.bcd.dto.DCDrawDetailResp;
import com.baidu.mapp.bcd.dto.DonateChainResp;
import com.baidu.mapp.bcd.dto.DonateDetailResp;
import com.baidu.mapp.bcd.dto.DonateFlatDetail;
import com.baidu.mapp.bcd.dto.DonationFlowBriefResp;
import com.baidu.mapp.bcd.dto.DonatoryChainResp;
import com.baidu.mapp.bcd.dto.DrawRecordFlatDetail;
import com.baidu.mapp.bcd.dto.Verification;
import com.baidu.mapp.bcd.dto.VerificationDetail;
import com.baidu.mapp.bcd.service.ActivityPlanConfigService;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.AdminService;
import com.baidu.mapp.bcd.service.AllocationService;
import com.baidu.mapp.bcd.service.CertificateService;
import com.baidu.mapp.bcd.service.ChainService;
import com.baidu.mapp.bcd.service.DonateDetailService;
import com.baidu.mapp.bcd.service.DonateFlowService;
import com.baidu.mapp.bcd.service.DonatoryService;
import com.baidu.mapp.bcd.service.DonorService;
import com.baidu.mapp.bcd.service.DrawRecordDetailService;
import com.baidu.mapp.bcd.service.DrawRecordFlowService;
import com.baidu.mapp.bcd.service.DrawRecordService;
import com.baidu.mapp.bcd.service.PlanAllocationRelService;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Schema(description = "捐赠接口", name = "DonateController")
@RestController
@RequestMapping("/donate")
@Slf4j
public class SupervisionController {

    @Autowired
    DonateFlowService donateFlowService;

    @Autowired
    DonateDetailService donateDetailService;

    @Autowired
    DonorService donorService;

    @Autowired
    ActivityPlanService activityPlanService;

    @Autowired
    ChainService chainService;

    @Autowired
    DrawRecordFlowService drawRecordFlowService;

    @Autowired
    DrawRecordDetailService drawRecordDetailService;

    @Autowired
    DrawRecordService drawRecordService;

    @Autowired
    DonatoryService donatoryService;

    @Autowired
    AllocationService allocationService;

    @Autowired
    PlanAllocationRelService planAllocationRelService;

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityPlanConfigService activityPlanConfigService;

    @Autowired
    AdminService adminService;

    @Autowired
    CertificateService certificateService;

    @Autowired
    Digest digest;

    /**
     * 按精确匹配存证地址, 查询受捐流程
     * @param address 存证地址
     * @return 返回整个从受捐到捐赠的追溯详情
     */
    @GetMapping("queryByDonatoryCertCode")
    public R<DonatoryChainResp> queryByDonatoryCertCode(@RequestParam String address) {
        // 查询受捐/领取流水
        DrawRecordFlow drawRecordFlow =
                drawRecordFlowService.selectOneByExample(DrawRecordFlowExample.newBuilder().build()
                        .createCriteria()
                        .andCertCodeEqualTo(address)
                        .toExample());
        Assert.isTrue(drawRecordFlow != null, "领取流水不存在");

        Long drawRecordFlowId = drawRecordFlow.getId();
        Long donatoryId = drawRecordFlow.getDonatoryId();
        Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);
        Assert.isTrue(donatory != null, "受捐人不存在");

        // 查询领取记录
        List<DrawRecord> drawRecords = drawRecordService.selectByExample(DrawRecordExample.newBuilder().build()
                .createCriteria()
                .andDrawRecordFlowIdEqualTo(drawRecordFlowId)
                .toExample());
        List<DCDrawDetailResp> dcDrawDetailResps = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(drawRecords)) {
            for (DrawRecord dr : drawRecords) {
                dcDrawDetailResps.add(DCDrawDetailResp.builder()
                        .type(dr.getType())
                        .unit(dr.getUnit())
                        .quantity(dr.getQuantity())
                        .name(dr.getName())
                        .build());
            }
        }

        DonatoryChainResp donatoryChainResp = DonatoryChainResp.builder()
                .drawRecordFlowId(drawRecordFlowId)
                .donatoryId(donatoryId)
                .donatoryName(MaskUtils.maskDonorName(donatory.getDonatoryName()))
                .drawTime(drawRecordFlow.getDrawTime())
                .certCode(drawRecordFlow.getCertCode())
                .drawDetailResps(dcDrawDetailResps)
                .build();

        Activity activity = activityService.selectByPrimaryKey(drawRecordFlow.getActivityId());
        Assert.isTrue(activity != null, "受捐活动不存在");

        DCActivityBriefResp activityBriefResp = DCActivityBriefResp.builder()
                .activityId(activity.getId())
                .theme(activity.getTheme())
                .description(activity.getDescription())
                .startTime(activity.getStartTime())
                .status(activity.getStatus())
                .endTime(activity.getEndTime())
                .build();
        donatoryChainResp.setActivityBriefResp(activityBriefResp);

        // 查询捐赠明细, 需用从allocation来看
        List<DrawRecordDetail> drawRecordDetails =
                drawRecordDetailService.selectByExample(DrawRecordDetailExample.newBuilder().build()
                        .createCriteria()
                        .andActivityIdEqualTo(activity.getId())
                        .andDonatoryIdEqualTo(donatoryId)
                        .toExample());
        List<Long> allocationIds =
                drawRecordDetails.stream().map(DrawRecordDetail::getAllocationId).collect(Collectors.toList());
        List<Allocation> allocations = allocationService.selectByPrimaryKeys(allocationIds);
        List<Long> donateDetailIds = allocations.stream().map(Allocation::getDonateDetailId).collect(Collectors.toList());

        Map<Long, List<DonateDetail>> donateDetailsMap =
                donateDetailService.selectMapListByExample(DonateDetailExample.newBuilder().build()
                        .createCriteria()
                        .andIdIn(donateDetailIds)
                        .toExample(), DonateDetail::getId, item -> item);
        List<DonateFlatDetail> donateFlatDetails = Lists.newArrayList();
        activityBriefResp.setDonateFlatDetails(donateFlatDetails);
        if (!CollectionUtils.isEmpty(allocations)) {
            for (Allocation allocation : allocations) {
                Long donateDetailId = allocation.getDonateDetailId();
                DonateDetail donateDetail = donateDetailsMap.get(donateDetailId).get(0);
                DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(donateDetail.getFlowId());
                Donor donor = donorService.selectByPrimaryKey(donateFlow.getDonorId());
                String donorName = donateFlow.getIsAnonymous() == 1 ? donateFlow.getAnonymity() : donor.getDonorName();
                DonateFlatDetail donateFlatDetail = DonateFlatDetail.builder()
                        .donateFlowId(donateDetail.getFlowId())
                        .donateDetailId(donateDetail.getId())
                        .donorName(MaskUtils.maskDonorName(donorName))
                        .donateTime(donateFlow.getDonateTime())
                        .certCode(donateFlow.getCertCode())
                        .type(donateDetail.getType())
                        .unit(donateDetail.getUnit())
                        .quantity(donateDetail.getQuantity())
                        .name(donateDetail.getName())
                        .build();
                donateFlatDetails.add(donateFlatDetail);
            }
        }
        return R.ok(donatoryChainResp);
    }

    /**
     * 按精确匹配存证地址, 查询捐款流程
     * @param address 存证地址
     * @return 返回整个从捐赠到受捐的追溯详情
     */
    @GetMapping("queryByDonorCertCode")
    public DonateChainResp queryDonationsByDonateCertCode(@RequestParam String address) {

        DonateFlow donateFlow = donateFlowService.selectOneByExample(DonateFlowExample.newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(address)
                .toExample());
        Assert.isTrue(donateFlow != null, "捐赠流水不存在");

        Long donorId = donateFlow.getDonorId();
        Donor donor = donorService.selectByPrimaryKey(donorId);
        Assert.isTrue(donor != null, "捐赠人不存在");

        String displayName = donateFlow.getIsAnonymous() == 1 ? donateFlow.getAnonymity() : donor.getDonorName();
        // 捐赠流水记录
        DonateChainResp donateChainResp = DonateChainResp.builder()
                .donateFlowId(donateFlow.getId())
                .donorId(donor.getId())
                .donorName(MaskUtils.maskDonorName(displayName))
                .isAnonymous(donateFlow.getIsAnonymous())
                .anonymity(donateFlow.getAnonymity())
                .donateTime(donateFlow.getDonateTime())
                .certCode(address)
                .build();

        // 捐赠详情
        List<DonateDetail> donateDetails = donateDetailService.selectByExample(DonateDetailExample.newBuilder()
                .build()
                .createCriteria()
                .andFlowIdEqualTo(donateFlow.getId())
                .toExample());

        List<DonateDetailResp> donateDetailResps = new ArrayList<>(donateDetails.size());
        donateDetails.forEach((DonateDetail dd) -> {
            donateDetailResps.add(DonateDetailResp.builder()
                    .type(dd.getType())
                    .unit(dd.getUnit())
                    .quantity(dd.getQuantity())
                    .name(dd.getName())
                    .build());
        });
        donateChainResp.setDonateDetailResp(donateDetailResps);

        // 捐赠对应的活动摘要（包含受捐详情）
        List<Long> donateDetailIds = donateDetails.stream().map(DonateDetail::getId).collect(Collectors.toList());

        List<Allocation> allocations = allocationService.selectByExample(AllocationExample.newBuilder().build()
                .createCriteria()
                .andDonateDetailIdIn(donateDetailIds)
                .toExample());
        List<Long> allocationIds = allocations.stream().map(Allocation::getId).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(allocationIds)) {
            // 该笔捐赠还没有被分配使用
            return donateChainResp;
        }

        // 通过分配记录倒推应用于哪些活动
        List<PlanAllocationRel> planAllocationRels =
                planAllocationRelService.selectByExample(PlanAllocationRelExample.newBuilder().build()
                        .createCriteria()
                        .andAllocationIdIn(allocationIds)
                        .toExample());
        if (CollectionUtils.isEmpty(planAllocationRels)) {
            // 表示捐赠还未用于任何活动
            donateChainResp.setActivityBriefResps(Lists.newArrayList());
            return donateChainResp;
        }

        List<Long> actPlanIds =
                planAllocationRels.stream().map(PlanAllocationRel::getActivityPlanId).collect(Collectors.toList());

        List<ActivityPlan> activityPlans = activityPlanService.selectByPrimaryKeys(actPlanIds);
        Set<Long> actIds = activityPlans.stream().map(ActivityPlan::getActivityId).collect(Collectors.toSet());

        List<Activity> activities = activityService.selectByPrimaryKeys(new ArrayList<>(actIds));

        List<DCActivityBriefResp> activityBriefResps = new ArrayList<>();
        donateChainResp.setActivityBriefResps(activityBriefResps);
        for (Activity act : activities) {
            DCActivityBriefResp dcActivityBriefResp = DCActivityBriefResp.builder()
                    .activityId(act.getId())
                    .theme(act.getTheme())
                    .description(act.getDescription())
                    .startTime(act.getStartTime())
                    .endTime(act.getEndTime())
                    .status(act.getStatus())
                    .build();
            activityBriefResps.add(dcActivityBriefResp);

            // 根据状态查找受捐领取摘要
            List<DrawRecordFlatDetail> drawRecordFlatDetails = new ArrayList<>();

            List<DrawRecordFlow> drawRecordFlows =
                    drawRecordFlowService.selectByExample(DrawRecordFlowExample.newBuilder().build()
                            .createCriteria()
                            .andActivityIdEqualTo(act.getId())
                            .toExample());
            if (!CollectionUtils.isEmpty(drawRecordFlows)) {
                for (DrawRecordFlow drawRecordFlow : drawRecordFlows) {
                    Long drawRecordFlowId = drawRecordFlow.getId();
                    Long donatoryId = drawRecordFlow.getDonatoryId();

                    DrawRecord drawRecord = drawRecordService.selectOneByExample(DrawRecordExample.newBuilder().build()
                            .createCriteria()
                            .andDrawRecordFlowIdEqualTo(drawRecordFlowId)
                            .toExample());
                    Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);

                    DrawRecordFlatDetail flatDetail = DrawRecordFlatDetail.builder()
                            .donatoryId(donatoryId)
                            .drawFlowId(drawRecordFlowId)
                            .drawTime(drawRecordFlow.getDrawTime())
                            .donatoryName(MaskUtils.maskDonorName(donatory.getDonatoryName()))
                            .certCode(drawRecordFlow.getCertCode())
                            .unit(drawRecord.getUnit())
                            .type(drawRecord.getType())
                            .name(drawRecord.getName())
                            .quantity(drawRecord.getQuantity())
                            .build();
                    drawRecordFlatDetails.add(flatDetail);
                }
            }
            dcActivityBriefResp.setDrawRecordFlatDetails(drawRecordFlatDetails);
        }

        return donateChainResp;
    }

    /**
     * 敏感信息(如手机号、身份证号等)解密
     */
    private String decryptInternal(String encrypted) {
        if (StringUtils.isNotEmpty(encrypted)) {
            try {
                return digest.decryptDes(encrypted);
            } catch (Exception e) {
            }
        }
        return StringUtils.EMPTY;
    }

}
