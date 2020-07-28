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
import com.baidu.mapp.bcd.domain.Admin;
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
import com.baidu.mapp.bcd.domain.DrawRecordExample;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.DrawRecordFlowExample;
import com.baidu.mapp.bcd.domain.base.Pagination;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
import com.baidu.mapp.bcd.dto.AllDonationFlowResp;
import com.baidu.mapp.bcd.dto.DonateDetailReq;
import com.baidu.mapp.bcd.dto.DonateDetailResp;
import com.baidu.mapp.bcd.dto.DonateReq;
import com.baidu.mapp.bcd.dto.DonateResp;
import com.baidu.mapp.bcd.dto.DonationFlowBriefResp;
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
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CertificateService certificateService;

    public static final String PARTICIPATION_DONATE = "捐赠";

    public static final String PARTICIPATION_RECEIVE = "受捐";

    public static final String ANONYMITY_PREFIX = "雷锋";

    @Autowired
    Digest digest;

    /**
     * 新增/提交一笔捐赠
     */
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

        // 精确到秒，避免MYSQL存储损失时间精度，导致签名校验失败
        Date donateTime = new Date(System.currentTimeMillis() / 1000 * 1000);
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

        // 签名
        String sign = SignUtils.sign(donor.getDonorName(), donor.getIdcard(), donateTimeInString,
                donateDetailMapList);
        // 数据上链
        String address = chainService.writeChain(donorId, MetaDonateFlow.TABLE_NAME, flowId, sign, writeChainStr);
        flow.setCertCode(address);
        flow.setSign(sign);
        flow.setLastModifyTime(new Date());
        donateFlowService.updateByPrimaryKeySelective(flow);

        DonateResp donateResp = DonateResp.builder()
                .certCode(address)
                .donorName(donor.getDonorName())
                .quantity(details.get(0).getQuantity())
                .donateTime(flow.getDonateTime())
                .build();
        // 返回上链存证地址
        return R.ok(donateResp);
    }

    /**
     * 根据捐赠/受捐人名称/证书查询记录
     */
    @GetMapping("/genericSearch")
    public R<List<DonationFlowBriefResp>> genericSearch(@RequestParam String query) {
        // 先精准匹配证书号
        Certificate certificate = certificateService.selectOneByExample(CertificateExample
                .newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(query)
                .toExample());
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
     * 查询所有的捐赠记录，返回指定分页的结果
     */
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
