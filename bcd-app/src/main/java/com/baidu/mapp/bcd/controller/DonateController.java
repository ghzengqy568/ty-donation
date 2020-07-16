/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.ActivityPlan;
import com.baidu.mapp.bcd.domain.ActivityPlanExample;
import com.baidu.mapp.bcd.domain.Admin;
import com.baidu.mapp.bcd.domain.Allocation;
import com.baidu.mapp.bcd.domain.AllocationExample;
import com.baidu.mapp.bcd.domain.Certificate;
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
import com.baidu.mapp.bcd.domain.meta.MetaDonateDetail;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecord;
import com.baidu.mapp.bcd.dto.AllDonationFlowResp;
import com.baidu.mapp.bcd.dto.DCActivityBriefResp;
import com.baidu.mapp.bcd.dto.DCDrawDetailResp;
import com.baidu.mapp.bcd.dto.DonateChainResp;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateDetailResp;
import com.baidu.mapp.bcd.dto.DonateFlatDetail;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.dto.DonationFlowBriefResp;
import com.baidu.mapp.bcd.dto.DonatoryChainResp;
import com.baidu.mapp.bcd.dto.DrawRecordFlatDetail;
import com.baidu.mapp.bcd.service.ActivityPlanConfigService;
import com.baidu.mapp.bcd.service.ActivityPlanService;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.AdminService;
import com.baidu.mapp.bcd.service.AllocationService;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonateDetailService;
import com.baidu.mapp.bcd.service.DonateFlowService;
import com.baidu.mapp.bcd.service.DonatoryService;
import com.baidu.mapp.bcd.service.DonorService;
import com.baidu.mapp.bcd.service.DrawRecordDetailService;
import com.baidu.mapp.bcd.service.DrawRecordFlowService;
import com.baidu.mapp.bcd.service.DrawRecordService;
import com.baidu.mapp.bcd.service.PlanAllocationRelService;
import com.google.common.collect.Lists;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    ActivityPlanService activityPlanService;

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

    public static final String PARTICIPATION_DONATE = "捐赠";

    public static final String PARTICIPATION_RECEIVE = "受捐";

    public static final String ANONYMITY_PREFIX = "雷锋";

    @PostMapping("submit")
    public R<String> submit(@RequestBody DonateReq donateReq) {
        Long loginId = donateReq.getLoginId();
        Long donorId;
        // todo 判断操作人是否为管理员
        Admin admin = adminService.selectByPrimaryKey(loginId);
        Boolean isAdmin = admin == null ? false : true;
        if (isAdmin) {
            donorId = donateReq.getDonorId();
            if (donorId == null || donorId <=0 ) {
                return R.error(100101, "捐赠人Id不能为空");
            }
        } else {
            // 非管理员操作, 则捐赠人为操作人本身
            donorId = loginId;
        }

        if (CollectionUtils.isEmpty(donateReq.getDetails())) {
            return R.error(100101, "捐赠明细不能为空");
        }
        Donor donor = donorService.selectByPrimaryKey(donorId);
        if (donor == null) {
            return R.error(100102, "捐赠人不存在");
        }

        Date donateTime = new Date();
        String anonymity = Strings.EMPTY;
        if (donateReq.getIsAnonymous() == 1) {
            anonymity = ANONYMITY_PREFIX + RandomStringUtils.randomNumeric(10);
        }
        // 流水签名 donorId, donorTime
        String sign = SignUtils.sign(donorId, DateTimeUtils.toDateTimeString(donateTime, "yyyyMMddHHmmss"));
        DonateFlow flow = DonateFlow.newBuilder()
                .donorId(donorId)
                .donateTime(donateTime)
                .sign(sign)
//                .anonymity(anonymity)  todo
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
    public R<Pagination<AllDonationFlowResp>> getAllDonations(@RequestParam(defaultValue = "1") Integer pageNo,
                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                              @RequestParam(required = false) Long donorId) {

        int start = (pageNo - 1) * pageSize;

        if (donorId != null) {
            // 捐赠人登录, 展示其本人的所有捐赠记录
            List<DonateFlow> donateFlows = donateFlowService.selectByExample(DonateFlowExample.newBuilder().build()
                    .createCriteria()
                    .andDonorIdEqualTo(donorId)
                    .toExample());
            if (CollectionUtils.isEmpty(donateFlows)) {
                Pagination<AllDonationFlowResp> pagination = new Pagination<>();
                pagination.setTotal(0L);
                pagination.setDataList(Lists.newArrayList());
                return R.ok(pagination);
            }
            List<Long> flowIds = donateFlows.stream().map(DonateFlow::getId).collect(Collectors.toList());
            Pagination<AllDonationFlowResp> pagination =
                    donateDetailService.pagination(DonateDetailExample.newBuilder()
                            .orderByClause("create_time desc")
                            .start(start).limit(pageSize)
                            .build().createCriteria().andFlowIdIn(flowIds).toExample(), toDisplayConvert());
            return R.ok(pagination);
        } else {
            // 管理员登录, 展示系统内所有人的捐赠记录
            Pagination<AllDonationFlowResp> pagination =
                    donateDetailService.pagination(DonateDetailExample.newBuilder()
                            .orderByClause("create_time desc").start(start)
                            .limit(pageSize)
                            .build(), toDisplayConvert());

            return R.ok(pagination);
        }
    }

    private Function<DonateDetail, AllDonationFlowResp> toDisplayConvert() {
        return (DonateDetail donateDetail) -> {
            Long donateFlowId = donateDetail.getFlowId();
            DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(donateFlowId);
            Long donorId = donateFlow.getDonorId();
            Donor donor = donorService.selectByPrimaryKey(donorId);
            String donorName = donor.getDonorName();
            // todo 如果匿名捐赠, 展示雷锋***, 否则, 展示捐赠人名称(需要掩码 -- todo)
            String displayName = donateFlow.getIsAnonymous() == 1 ? donateFlow.getAnonymity() :
                    donor.getDonorName();
            return AllDonationFlowResp.builder()
                    .donorName(displayName)
                    .donateTime(donateFlow.getDonateTime())
                    .certCode(donateFlow.getCertCode())
                    .participation(PARTICIPATION_DONATE)
                    .type(donateDetail.getType())
                    .unit(donateDetail.getUnit())
                    .quantity(donateDetail.getQuantity())
                    .name(donateDetail.getName())
                    .build();

        };
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
                List<DonateDetailResp> donateDetails =
                        donateDetailService.selectByExample(DonateDetailExample.newBuilder().build()
                                .createCriteria()
                                .andFlowIdEqualTo(sourceId)
                                .toExample(), item -> {
                            return DonateDetailResp.builder()
                                    .type(item.getType())
                                    .unit(item.getUnit())
                                    .quantity(item.getQuantity())
                                    .name(item.getName())
                                    .build();
                        });
                String donorName = donateFlow.getIsAnonymous() == 1 ? donateFlow.getAnonymity() : donor.getDonorName();
                DonationFlowBriefResp donationFlowBriefResp = DonationFlowBriefResp.builder()
                        .certCode(donateFlow.getCertCode())
                        .donateTime(donateFlow.getDonateTime())
                        .donorName(donorName)
                        .participation(PARTICIPATION_DONATE)
                        .donateDetailResps(donateDetails)
                        .build();
                return R.ok(Lists.newArrayList(donationFlowBriefResp));
            } else if (sourceTable.equalsIgnoreCase(MetaDrawRecord.TABLE_NAME)) {
                // 受捐人通过领取记录证书查询
                // sourceId 领取流水ID
                DrawRecordFlow drawRecordFlow = drawRecordFlowService.selectByPrimaryKey(sourceId);
                Long donatoryId = drawRecordFlow.getDonatoryId();
                Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);

                List<DonateDetailResp> drawRecords = drawRecordService.selectByExample(DrawRecordExample.newBuilder().build()
                        .createCriteria()
                        .andDrawRecordFlowIdEqualTo(sourceId)
                        .toExample(), item -> {
                    return DonateDetailResp.builder()
                            .type(item.getType())
                            .unit(item.getUnit())
                            .quantity(item.getQuantity())
                            .name(item.getName())
                            .build();
                });
                DonationFlowBriefResp donationFlowBriefResp = DonationFlowBriefResp.builder()
                        .certCode(drawRecordFlow.getCertCode())
                        .donateTime(drawRecordFlow.getDrawTime())
                        .donorName(donatory.getDonatoryName())
                        .participation(PARTICIPATION_RECEIVE)
                        .donateDetailResps(drawRecords)
                        .build();
                return R.ok(Lists.newArrayList(donationFlowBriefResp));
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
                List<DonateDetailResp> donateDetailResps = new ArrayList<>(donateDetails.size());
                if (!CollectionUtils.isEmpty(donateDetails)) {
                    donateDetails.forEach(item -> {
                        donateDetailResps.add(DonateDetailResp.builder()
                            .name(item.getName())
                            .type(item.getType())
                            .unit(item.getUnit())
                            .quantity(item.getQuantity())
                            .build());
                    });
                }
                String donorDisplayName = df.getIsAnonymous() == 1? df.getAnonymity()
                        : donorIdMap.get(df.getDonorId()).getDonorName();
                donateFlowResps.add(DonationFlowBriefResp.builder()
                        .certCode(df.getCertCode())
                        .donateTime(df.getDonateTime())
                        .donorName(donorDisplayName)
                        .participation(PARTICIPATION_DONATE)
                        .donateDetailResps(donateDetailResps)
                        .build());
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
                List<DonateDetailResp> drawRecordResps = new ArrayList<>(drawRecords.size());
                if (!CollectionUtils.isEmpty(drawRecords)) {
                    drawRecords.forEach(item -> {
                        drawRecordResps.add(DonateDetailResp.builder()
                                .name(item.getName())
                                .type(item.getType())
                                .unit(item.getUnit())
                                .quantity(item.getQuantity())
                                .build());
                    });
                }
                donateFlowResps.add(DonationFlowBriefResp.builder()
                        .certCode(drawRecordFlow.getCertCode())
                        .donateTime(drawRecordFlow.getDrawTime())
                        .donorName(donatoryIdMap.get(drawRecordFlow.getDonatoryId()).getDonatoryName())
                        .participation(PARTICIPATION_RECEIVE)
                        .donateDetailResps(drawRecordResps)
                        .build());
            });
        }
        return donateFlowResps;
    }

    /**
     * 按精确匹配证书号, 查询受捐流程
     * @param certCode 证书号
     * @return 返回整个从受捐到捐赠的追溯详情
     */
    @GetMapping("queryByDonatoryCertCode")
    public R<DonatoryChainResp> queryByDonatoryCertCode(@RequestParam String certCode) {
        List<DrawRecordFlow> drawRecordFlows =
                drawRecordFlowService.selectByExample(DrawRecordFlowExample.newBuilder().build()
                        .createCriteria()
                        .andCertCodeEqualTo(certCode)
                        .toExample());
        Assert.isTrue(drawRecordFlows != null && drawRecordFlows.size() == 1, "领取流水不存在");
        DrawRecordFlow drawRecordFlow = drawRecordFlows.get(0);

        Long drawRecordFlowId = drawRecordFlow.getId();
        Long donatoryId = drawRecordFlow.getDonatoryId();
        Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);
        Assert.isTrue(donatory != null, "受捐人不存在");

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
                .donatoryName(donatory.getDonatoryName())
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

        List<DonateDetail> donateDetails = donateDetailService.selectByExample(DonateDetailExample.newBuilder().build()
                .createCriteria()
                .andIdIn(donateDetailIds)
                .toExample());
        List<DonateFlatDetail> donateFlatDetails = Lists.newArrayList();
        activityBriefResp.setDonateFlatDetails(donateFlatDetails);
        if (!CollectionUtils.isEmpty(donateDetails)) {
            for (DonateDetail donateDetail : donateDetails) {
                DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(donateDetail.getFlowId());
                Donor donor = donorService.selectByPrimaryKey(donateFlow.getDonorId());
                String donorName = donateFlow.getIsAnonymous() == 1 ? donateFlow.getAnonymity() : donor.getDonorName();
                DonateFlatDetail donateFlatDetail = DonateFlatDetail.builder()
                        .donateFlowId(donateDetail.getFlowId())
                        .donateDetailId(donateDetail.getId())
                        .donorName(donorName)
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
     * 按精确匹配证书号, 查询捐款流程
     * @param certCode 证书号
     * @return 返回整个从捐赠到受捐的追溯详情
     */
    @GetMapping("queryByDonorCertCode")
    public DonateChainResp queryDonationsByDonateCertCode(@RequestParam String certCode) {

        List<DonateFlow> flows = donateFlowService.selectByExample(DonateFlowExample.newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(certCode)
                .toExample());
        Assert.isTrue(!CollectionUtils.isEmpty(flows) && flows.size() == 1, "捐赠流水不存在");

        DonateFlow donateFlow = flows.get(0);
        Long donorId = donateFlow.getDonorId();
        Donor donor = donorService.selectByPrimaryKey(donorId);
        Assert.isTrue(donor != null, "捐赠人不存在");

        // 捐赠流水记录
        DonateChainResp donateChainResp = DonateChainResp.builder()
                .donateFlowId(donateFlow.getId())
                .donorId(donor.getId())
                .donorName(donor.getDonorName())
                .isAnonymous(donateFlow.getIsAnonymous())
                .anonymity(donateFlow.getAnonymity())
                .donateTime(donateFlow.getDonateTime())
                .certCode(certCode)
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
        // todo actId -> List<actPlanId> map ???
        Map<Long, List<Long>> actPlansMap =
                activityPlanService.selectMapListByExample(ActivityPlanExample.newBuilder().build().createCriteria()
                        .toExample(), ActivityPlan::getActivityId, ActivityPlan::getId);

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
            // todo 啥是 实施中，实施完成
            // 根据 actId -> List<actPlanId> map ====> actPlanId + allocationId -> drawdetail

            List<DrawRecordFlatDetail> drawRecordFlatDetails = new ArrayList<>();
            List<DrawRecordDetail> drawRecordDetails =
                    drawRecordDetailService.selectByExample(DrawRecordDetailExample.newBuilder().build()
                            .createCriteria()
                            .andActivityIdEqualTo(act.getId())
                            .andActivityPlanIdIn(actPlansMap.get(act.getId()))
                            .toExample());
            if (CollectionUtils.isEmpty(drawRecordDetails)) {
                continue;
            }
            for (DrawRecordDetail drawRecordDetail : drawRecordDetails) {
                Long donatoryId = drawRecordDetail.getDonatoryId();

                List<DrawRecordFlow> drawRecordFlows =
                        drawRecordFlowService.selectByExample(DrawRecordFlowExample.newBuilder().build()
                                .createCriteria()
                                .andDonatoryIdEqualTo(donatoryId)
                                .andActivityIdEqualTo(drawRecordDetail.getActivityId())
                                .toExample());
                // 每个人在每次活动中只有一条领取记录
                DrawRecordFlow drawRecordFlow = drawRecordFlows.get(0);

                DrawRecordFlatDetail drawRecordFlatDetail = DrawRecordFlatDetail.builder()
                        .activityId(drawRecordDetail.getActivityId())
                        .activityPlanId(drawRecordDetail.getActivityPlanId())
                        .allocationId(drawRecordDetail.getAllocationId())
                        .donatoryId(drawRecordDetail.getDonatoryId())
                        .build();
                Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);
                drawRecordFlatDetail.setDonatoryName(donatory.getDonatoryName());

                ActivityPlan activityPlan =
                        activityPlanService.selectByPrimaryKey(drawRecordDetail.getActivityPlanId());

                drawRecordFlatDetail.setType(activityPlan.getType());
                drawRecordFlatDetail.setUnit(activityPlan.getUnit());
                drawRecordFlatDetail.setName(activityPlan.getName());
                drawRecordFlatDetail.setQuantity(drawRecordDetail.getUsed());
                drawRecordFlatDetail.setDrawTime(drawRecordFlow.getDrawTime());
                drawRecordFlatDetail.setCertCode(drawRecordFlow.getCertCode());
                drawRecordFlatDetails.add(drawRecordFlatDetail);
            }
            dcActivityBriefResp.setDrawRecordFlatDetails(drawRecordFlatDetails);
        }

        return donateChainResp;
    }

}
