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
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
import com.baidu.mapp.bcd.dto.AllDonationFlowResp;
import com.baidu.mapp.bcd.dto.DCActivityBriefResp;
import com.baidu.mapp.bcd.dto.DCDrawDetailResp;
import com.baidu.mapp.bcd.dto.DonateChainResp;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateDetailResp;
import com.baidu.mapp.bcd.dto.DonateFlatDetail;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.dto.DonateResp;
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
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Comparator;
import java.util.Date;
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

    public static final String PARTICIPATION_DONATE = "捐赠";

    public static final String PARTICIPATION_RECEIVE = "受捐";

    public static final String ANONYMITY_PREFIX = "雷锋";

    @Autowired
    Digest digest;

    @GetMapping("verify")
    public R<Verification> verify(@RequestParam String certCode) {
        // READ_CHAIN 校验链上和链下捐赠详情
        try {
            String chainContent = chainService.readChain(certCode);
            String fromTable = StringUtils.EMPTY;
            String fromId = StringUtils.EMPTY;
            String donateContent = StringUtils.EMPTY;
            if (StringUtils.isNotBlank(chainContent)) {
                String[] split = chainContent.split("\t");
                String source = split[1];
                String[] srcArray = source.split(":");
                fromTable = srcArray[0];
                fromId = srcArray[1];
                String content = split[2];

                String[] split1 = content.split(":");
                try {
                    donateContent = digest.decryptDes(split1[1]);
                } catch (Exception e) {
                    log.error("Fail to read from chain.", e);
                    return R.error(2001001, "获取链上数据失败, 请稍后重试!");
                }
            }

            if (StringUtils.isNotEmpty(donateContent)) {
                JsonObject jsonObject = GsonUtils.toJsonObject(donateContent);

                String donorName = jsonObject.get(ChainConstants.DONATE_FLOW_DONOR_NAME).getAsString();
                String donateTime = jsonObject.get(ChainConstants.DONATE_FLOW_DONATE_TIME).getAsString();
                String idCard = jsonObject.get(ChainConstants.DONATE_FLOW_DONOR_ID_CARD).getAsString();

                List<VerificationDetail> details = Lists.newArrayList();
                JsonArray detailJsonArray = jsonObject.getAsJsonArray(ChainConstants.DONATE_DETAIL);
                detailJsonArray.forEach(element -> {
                    details.add(VerificationDetail.builder()
                            .name(element.getAsJsonObject().get(ChainConstants.DONATE_DETAIL_NAME)
                                    .getAsString())
                            .quantity(element.getAsJsonObject().get(ChainConstants.DONATE_DETAIL_QUANTITY)
                                    .getAsLong())
                            .unit(element.getAsJsonObject().get(ChainConstants.DONATE_DETAIL_UNIT)
                                    .getAsString())
                            .build());
                });

                // 校验过程
                if (!fromTable.equals(MetaDonateFlow.TABLE_NAME)) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                DonateFlow donateFlowInDB = donateFlowService.selectByPrimaryKey(Long.valueOf(fromId));
                Long donorIDInDB = donateFlowInDB.getDonorId();
                Donor donorInDB = donorService.selectByPrimaryKey(donorIDInDB);
                if (!donorName.equals(donorInDB.getDonorName()) || !idCard.equals(donorInDB.getIdcard())) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                List<Map<String, Object>> donateDetailMapList = Lists.newArrayList();
                List<DonateDetail> donateDetails =
                        donateDetailService.selectByExample(DonateDetailExample.newBuilder().build()
                                .createCriteria()
                                .andFlowIdEqualTo(Long.valueOf(fromId))
                                .toExample());
                if (!CollectionUtils.isEmpty(donateDetails)) {
                    donateDetails.forEach((item) -> {
                        Map<String, Object> detailMap = new HashMap<>();
                        detailMap.put(ChainConstants.DONATE_DETAIL_NAME, item.getName());
                        detailMap.put(ChainConstants.DONATE_DETAIL_QUANTITY, item.getQuantity());
                        detailMap.put(ChainConstants.DONATE_DETAIL_UNIT, item.getUnit());
                        donateDetailMapList.add(detailMap);
                    });
                }

                if (details.size() != donateDetailMapList.size()) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                for (VerificationDetail detail : details) {
                    boolean matched = false;
                    for (Map<String, Object> map : donateDetailMapList) {
                        if (detail.getName().equals(map.get(ChainConstants.DONATE_DETAIL_NAME))
                                && detail.getQuantity().equals(map.get(ChainConstants.DONATE_DETAIL_QUANTITY))
                                && detail.getUnit().equals(map.get(ChainConstants.DONATE_DETAIL_UNIT))) {
                            matched = true;
                            break;
                        }
                    }
                    if (!matched) {
                        return R.ok(Verification.builder()
                                .pass(false)
                                .build());
                    }
                }

                // 构造校验结果
                Verification verification = Verification.builder()
                        .pass(true)
                        .donorOrDonatoryName(MaskUtils.maskDonorName(donorName))
                        .idCard(MaskUtils.maskIdCard(idCard))
                        .time(donateFlowInDB.getDonateTime())
                        .drawVerificationDetailList(details)
                        .build();
                return R.ok(verification);
            }
            return R.error(2001002, "链上数据读取为空");
        } catch (Exception e) {
            log.error("Fail to verify donate information.", e);
            return R.ok(Verification.builder()
                    .pass(false)
                    .build());
        }
    }

    @PostMapping("submit")
    public R<DonateResp> submit(@RequestBody DonateReq donateReq) {
        Long loginId = donateReq.getLoginId();
        Long donorId;
        // 判断操作人是否为管理员
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
            anonymity = ANONYMITY_PREFIX + RandomStringUtils.randomNumeric(4);
        }
        DonateFlow flow = DonateFlow.newBuilder()
                .donorId(donorId)
                .donateTime(donateTime)
                .anonymity(anonymity)
                .isAnonymous(donateReq.getIsAnonymous())
                .createTime(new Date())
                .lastModifyTime(new Date())
                .build();
        donateFlowService.insertSelective(flow);
        Long flowId = flow.getId();

        List<Map<String, Object>> donateDetailMapList = Lists.newArrayList();
        // details ...
        List<DonateDetailReq> details = donateReq.getDetails();
        for (DonateDetailReq detail : details) {
            String name = detail.getName();
            Long quantity = detail.getQuantity();
            Byte type = detail.getType();
            String unit = detail.getUnit();

            Map<String, Object> detailMap = new HashMap<>();
            detailMap.put(ChainConstants.DONATE_DETAIL_NAME, name);
            detailMap.put(ChainConstants.DONATE_DETAIL_QUANTITY, quantity);
            detailMap.put(ChainConstants.DONATE_DETAIL_UNIT, unit);
            donateDetailMapList.add(detailMap);

            DonateDetail donateDetail = DonateDetail.newBuilder()
                    .flowId(flowId)
                    .createTime(new Date())
                    .lastModifyTime(new Date())
                    .name(name)
                    .quantity(quantity)
                    .balance(quantity)
                    .type(type)
                    .unit(unit)
                    .build();

            donateDetailService.insertSelective(donateDetail);
            Long detailId = donateDetail.getId();
            // WRITE_CHAIN 捐赠详情跟流水一起作为关键信息一次性上链, 不单独上链, 提高写入和查询验证效率
            // 是不是部分不单独上链表中的cert_code一列可以删除了
//            String detailCertCode = certService.writeChain(donorId, MetaDonateDetail.TABLE_NAME, detailId,
//                    sign, "xx");
//            donateDetail.setCertCode(detailCertCode);
//            donateDetail.setLastModifyTime(new Date());
            donateDetailService.updateByPrimaryKeySelective(donateDetail);
        }

        // WRITE_CHAIN 捐赠流水+详情一起作为关键信息一次性上链
        Map<String, Object> donateFlowMap = new HashMap<>();
        String donateTimeInString = DateTimeUtils.toDateTimeString(flow.getDonateTime(), "yyyy-MM-dd HH:mm:ss");
        donateFlowMap.put(ChainConstants.DONATE_FLOW_DONOR_NAME, donor.getDonorName());
        donateFlowMap.put(ChainConstants.DONATE_FLOW_DONOR_ID_CARD, donor.getIdcard());
        donateFlowMap.put(ChainConstants.DONATE_FLOW_DONATE_TIME, donateTimeInString);
        donateFlowMap.put(ChainConstants.DONATE_DETAIL, donateDetailMapList);
        String writeChainStr = GsonUtils.toJsonString(donateFlowMap);

        String sign = SignUtils.sign(donor.getDonorName(), donor.getIdcard(), donateTimeInString,
                donateDetailMapList);
        String certCode = chainService.writeChain(donorId, MetaDonateFlow.TABLE_NAME, flowId, sign, writeChainStr);
        flow.setCertCode(certCode);
        flow.setSign(sign);
        flow.setLastModifyTime(new Date());
        donateFlowService.updateByPrimaryKeySelective(flow);

        DonateResp donateResp = DonateResp.builder()
                .certCode(certCode)
                .donorName(donor.getDonorName())
                .quantity(details.get(0).getQuantity())
                .donateTime(flow.getDonateTime())
                .build();
        return R.ok(donateResp);
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

    private String decryptInternal(String encrypted) {
        if (StringUtils.isNotEmpty(encrypted)) {
            try {
                return digest.decryptDes(encrypted);
            } catch (Exception e) {
            }
        }
        return StringUtils.EMPTY;
    }

    private Function<DonateDetail, AllDonationFlowResp> toDisplayConvert() {
        return (DonateDetail donateDetail) -> {
            Long donateFlowId = donateDetail.getFlowId();
            DonateFlow donateFlow = donateFlowService.selectByPrimaryKey(donateFlowId);
            Long donorId = donateFlow.getDonorId();
            Donor donor = donorService.selectByPrimaryKey(donorId);
            String displayName = donateFlow.getIsAnonymous() == 1 ? donateFlow.getAnonymity() :
                    donor.getDonorName();
            String idCard = decryptInternal(donor.getIdcard());
            String mobile = decryptInternal(donor.getMobile());
            return AllDonationFlowResp.builder()
                    .donorName(MaskUtils.maskDonorName(displayName))
                    .idCard(MaskUtils.maskIdCard(idCard))
                    .phone(MaskUtils.maskCellPhone(mobile))
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
        Certificate certificate = chainService.queryCert(query);
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
                String idCard = decryptInternal(donor.getIdcard());
                String mobile = decryptInternal(donor.getMobile());
                DonationFlowBriefResp donationFlowBriefResp = DonationFlowBriefResp.builder()
                        .certCode(donateFlow.getCertCode())
                        .donateTime(donateFlow.getDonateTime())
                        .donorName(MaskUtils.maskDonorName(donorName))
                        .idCard(MaskUtils.maskIdCard(idCard))
                        .phone(MaskUtils.maskCellPhone(mobile))
                        .participation(PARTICIPATION_DONATE)
                        .donateDetailResps(donateDetails)
                        .build();
                return R.ok(Lists.newArrayList(donationFlowBriefResp));
            } else if (sourceTable.equalsIgnoreCase(MetaDrawRecordFlow.TABLE_NAME)) {
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
                String idCard = decryptInternal(donatory.getIdcard());
                String mobile = decryptInternal(donatory.getMobile());
                DonationFlowBriefResp donationFlowBriefResp = DonationFlowBriefResp.builder()
                        .certCode(drawRecordFlow.getCertCode())
                        .donateTime(drawRecordFlow.getDrawTime())
                        .donorName(MaskUtils.maskDonorName(donatory.getDonatoryName()))
                        .phone(MaskUtils.maskCellPhone(mobile))
                        .idCard(MaskUtils.maskIdCard(idCard))
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
            List<DonationFlowBriefResp> sortedResult = flowBriefResps.stream()
                    .sorted(Comparator.comparing(DonationFlowBriefResp::getDonateTime).reversed())
                    .collect(Collectors.toList());
            return R.ok(sortedResult);
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
                .andIsAnonymousEqualTo((byte) 0)
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
                String idCard = decryptInternal(donorIdMap.get(df.getDonorId()).getIdcard());
                String mobile = decryptInternal(donorIdMap.get(df.getDonorId()).getMobile());
                donateFlowResps.add(DonationFlowBriefResp.builder()
                        .certCode(df.getCertCode())
                        .donateTime(df.getDonateTime())
                        .donorName(MaskUtils.maskDonorName(donorDisplayName))
                        .phone(MaskUtils.maskCellPhone(mobile))
                        .idCard(MaskUtils.maskIdCard(idCard))
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
                String idCard = decryptInternal(donatoryIdMap.get(drawRecordFlow.getDonatoryId()).getIdcard());
                String mobile = decryptInternal(donatoryIdMap.get(drawRecordFlow.getDonatoryId()).getMobile());
                donateFlowResps.add(DonationFlowBriefResp.builder()
                        .certCode(drawRecordFlow.getCertCode())
                        .donateTime(drawRecordFlow.getDrawTime())
                        .donorName(MaskUtils.maskDonorName(donatoryIdMap.get(drawRecordFlow.getDonatoryId())
                                .getDonatoryName()))
                        .phone(MaskUtils.maskCellPhone(mobile))
                        .idCard(MaskUtils.maskIdCard(idCard))
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
        DrawRecordFlow drawRecordFlow =
                drawRecordFlowService.selectOneByExample(DrawRecordFlowExample.newBuilder().build()
                        .createCriteria()
                        .andCertCodeEqualTo(certCode)
                        .toExample());
        Assert.isTrue(drawRecordFlow != null, "领取流水不存在");

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
     * 按精确匹配证书号, 查询捐款流程
     * @param certCode 证书号
     * @return 返回整个从捐赠到受捐的追溯详情
     */
    @GetMapping("queryByDonorCertCode")
    public DonateChainResp queryDonationsByDonateCertCode(@RequestParam String certCode) {

        DonateFlow donateFlow = donateFlowService.selectOneByExample(DonateFlowExample.newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(certCode)
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

}
