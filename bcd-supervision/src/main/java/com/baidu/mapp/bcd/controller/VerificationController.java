package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.gson.GsonUtils;
import com.baidu.mapp.bcd.common.utils.ChainConstants;
import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.MaskUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Certificate;
import com.baidu.mapp.bcd.domain.CertificateExample;
import com.baidu.mapp.bcd.domain.DonateDetail;
import com.baidu.mapp.bcd.domain.DonateDetailExample;
import com.baidu.mapp.bcd.domain.DonateFlow;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DrawRecord;
import com.baidu.mapp.bcd.domain.DrawRecordExample;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateFlow;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Schema(description = "校验接口", name = "VerificationController")
@RestController
@RequestMapping("/verify")
@Slf4j
public class VerificationController {

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
     * 根据存证地址查询链上捐赠数据详情, 校验并返回校验结果
     * 校验过程：
     * - 验证证书是否有效
     * - 校验签名
     * - 校验数据类型及ID
     * - 校验捐赠详情（包含：捐赠人/身份证号/捐赠时间/详情）
     */
    @GetMapping("donation")
    public R<Verification> verifyDonation(@RequestParam String address) {
        // 查询链下证书地址相关记录
        Certificate certificate = certificateService.selectOneByExample(CertificateExample.newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(address)
                .toExample()
        );
        // 证书地址无效，不需继续查询查链，防止用户恶意攻击
        if (certificate == null) {
            return R.error(100102, "证书地址无效");
        }

        // 查询链下捐赠流水和详情, 为计算签名和与链上数据校验做准备
        Long flowId = certificate.getSourceId();
        DonateFlow donateFlowInDB = donateFlowService.selectByPrimaryKey(flowId);
        Long donorIDInDB = donateFlowInDB.getDonorId();
        Donor donorInDB = donorService.selectByPrimaryKey(donorIDInDB);

        List<Map<String, Object>> donateDetailMapList = Lists.newArrayList();
        List<DonateDetail> donateDetails =
                donateDetailService.selectByExample(DonateDetailExample.newBuilder().build()
                        .createCriteria()
                        .andFlowIdEqualTo(flowId)
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

        // READ_CHAIN 查询链上捐赠数据，校验链上和链下捐赠详情
        try {
            // 根据捐赠存证地址查询链上数据详情
            String chainContent = chainService.readChain(address);
            String domain = StringUtils.EMPTY;
            String domainId = StringUtils.EMPTY;
            String donateContent = StringUtils.EMPTY;
            String signInChain = StringUtils.EMPTY;
            if (StringUtils.isNotBlank(chainContent)) {
                String[] split = chainContent.split("\t");
                // 解析数据标识
                String identityId = split[1];
                String[] srcArray = identityId.split(":");
                domain = srcArray[0];
                domainId = srcArray[1];
                String content = split[2];

                // 解析数据内容
                String[] contentEnrypted = content.split(":");
                try {
                    signInChain = contentEnrypted[0];
                    // 链上真实数据解密
                    donateContent = digest.decryptDes(contentEnrypted[1]);
                } catch (Exception e) {
                    log.error("Fail to read from chain.", e);
                    return R.error(2001001, "获取链上数据失败, 请稍后重试!");
                }
            }

            String donateTimeInString = DateTimeUtils.toDateTimeString(donateFlowInDB.getDonateTime(), "yyyy-MM-dd "
                    + "HH:mm:ss");

            // 计算签名
            String sign = signDonation(donorInDB.getDonorName(), donorInDB.getIdcard(), donateTimeInString,
                    donateDetailMapList);
            // 校验签名
            if (!StringUtils.equals(sign, signInChain)) {
                return R.ok(Verification.builder()
                        .pass(false)
                        .build());
            }

            // 解析链上捐赠数据详情
            if (StringUtils.isNotEmpty(donateContent)) {
                JsonObject jsonObject = GsonUtils.toJsonObject(donateContent);

                String donorName = jsonObject.get(ChainConstants.DONATE_FLOW_DONOR_NAME).getAsString();
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

                // 校验1：校验数据类型及ID
                if (!domain.equals(MetaDonateFlow.TABLE_NAME) || !domainId.equals(flowId.toString())) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                // 校验2：校验捐赠人和身份证信息
                if (!donorName.equals(donorInDB.getDonorName()) || !idCard.equals(donorInDB.getIdcard())) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                // 校验3：校验捐赠详情
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

                // 构造并返回校验结果
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

    /**
     * 根据存证地址查询链上受捐/领取数据详情, 校验并返回校验结果
     * 校验过程：
     * - 验证证书是否有效
     * - 校验签名
     * - 校验数据类型及ID
     * - 校验受捐/领取详情（包含：受捐人/身份证号/受捐时间/详情）
     */
    @GetMapping("draw")
    public R<Verification> verifyDraw(@RequestParam String address) {
        // 查询链下证书地址相关记录
        Certificate certificate = certificateService.selectOneByExample(CertificateExample.newBuilder()
                .build()
                .createCriteria()
                .andCertCodeEqualTo(address)
                .toExample()
        );
        // 证书地址无效，不需继续查询查链，防止用户恶意攻击
        if (certificate == null) {
            return R.error(100102, "证书地址无效");
        }

        // 查询链下领取流水和详情, 为计算签名和与链上数据校验做准备
        Long flowId = certificate.getSourceId();
        DrawRecordFlow drawRecordFlow = drawRecordFlowService.selectByPrimaryKey(flowId);
        Assert.isTrue(drawRecordFlow != null, "领取流水不存在!");
        Long donatoryId = drawRecordFlow.getDonatoryId();
        Donatory donatory = donatoryService.selectByPrimaryKey(donatoryId);
        Assert.isTrue(donatory != null, "受捐人不存在!");
        List<Map<String, Object>> drawDetailMapList = Lists.newArrayList();
        // 查询领取详情
        List<DrawRecord> drawRecords = drawRecordService.selectByExample(DrawRecordExample.newBuilder().build()
                .createCriteria()
                .andDrawRecordFlowIdEqualTo(drawRecordFlow.getId())
                .toExample());
        if (!CollectionUtils.isEmpty(drawRecords)) {
            for (DrawRecord record : drawRecords) {
                Map<String, Object> drawDetailMap = new HashMap<>();
                drawDetailMap.put(ChainConstants.DRAW_DETAIL_NAME, record.getName());
                drawDetailMap.put(ChainConstants.DRAW_DETAIL_QUANTITY, record.getQuantity());
                drawDetailMap.put(ChainConstants.DRAW_DETAIL_UNIT, record.getUnit());
                drawDetailMapList.add(drawDetailMap);
            }
        }

        // READ_CHAIN 查询链上领取数据, 校验链下和链上领取详情
        try {
            String chainContent = chainService.readChain(address);
            String domain = StringUtils.EMPTY;
            String domainId = StringUtils.EMPTY;
            String drawContent = StringUtils.EMPTY;
            String signInChain = StringUtils.EMPTY;
            if (StringUtils.isNotBlank(chainContent)) {
                String[] split = chainContent.split("\t");
                String source = split[1];
                // 解析数据标识
                String[] identityId = source.split(":");
                domain = identityId[0];
                domainId = identityId[1];
                String content = split[2];

                // 解析链上数据内容
                String[] contentEncrypted = content.split(":");
                try {
                    signInChain = contentEncrypted[0];
                    // 链上真实数据解密
                    drawContent = digest.decryptDes(contentEncrypted[1]);
                } catch (Exception e) {
                    log.error("Fail to read from chain.", e);
                    return R.error(2001001, "获取链上数据失败, 请稍后重试!");
                }
            }

            String drawTimeInString = DateTimeUtils.toDateTimeString(drawRecordFlow.getDrawTime(),
                    "yyyy-MM-dd HH:mm:ss");

            // 计算签名
            String sign = signDraw(donatory.getDonatoryName(), donatory.getIdcard(), drawTimeInString,
                    drawDetailMapList);
            // 校验签名
            if (!StringUtils.equals(sign, signInChain)) {
                return R.ok(Verification.builder()
                        .pass(false)
                        .build());
            }

            // 解析链上受捐领取数据详情
            if (!StringUtils.isEmpty(drawContent)) {
                JsonObject jsonObject = GsonUtils.toJsonObject(drawContent);

                String donatoryName = jsonObject.get(ChainConstants.DRAw_FLOW_DONATORY_NAME).getAsString();
                String idCard = jsonObject.get(ChainConstants.DRAW_FLOW_DONATORY_ID_CARD).getAsString();

                List<VerificationDetail> details = Lists.newArrayList();
                JsonArray detailJsonArray = jsonObject.getAsJsonArray(ChainConstants.DRAW_DETAIL);
                detailJsonArray.forEach(element -> {
                    details.add(VerificationDetail.builder()
                            .name(element.getAsJsonObject().get(ChainConstants.DRAW_DETAIL_NAME)
                                    .getAsString())
                            .quantity(element.getAsJsonObject().get(ChainConstants.DRAW_DETAIL_QUANTITY)
                                    .getAsLong())
                            .unit(element.getAsJsonObject().get(ChainConstants.DRAW_DETAIL_UNIT)
                                    .getAsString())
                            .build());
                });
                // 校验1: 校验数据类型
                if (!domain.equals(MetaDrawRecordFlow.TABLE_NAME) || !domainId.equals(flowId.toString())) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                // 校验2：校验受捐人和身份证信息
                if (!donatory.getDonatoryName().equals(donatoryName)
                        || !idCard.equals(donatory.getIdcard())) {
                    return R.ok(Verification.builder()
                            .pass(false)
                            .build());
                }

                // 校验3：校验领取详情
                if (!CollectionUtils.isEmpty(details)) {
                    for (VerificationDetail detail : details) {
                        boolean matched = false;
                        for (Map<String, Object> map : drawDetailMapList) {
                            if (detail.getName().equals(map.get(ChainConstants.DRAW_DETAIL_NAME))
                                    && detail.getQuantity().equals(map.get(ChainConstants.DRAW_DETAIL_QUANTITY))
                                    && detail.getUnit().equals(map.get(ChainConstants.DRAW_DETAIL_UNIT))) {
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
                }

                // 返回校验结果
                Verification verification = Verification.builder()
                        .pass(true)
                        .donorOrDonatoryName(MaskUtils.maskDonorName(donatoryName))
                        .idCard(MaskUtils.maskIdCard(idCard))
                        .time(drawRecordFlow.getDrawTime())
                        .drawVerificationDetailList(details)
                        .build();
                return R.ok(verification);
            }
            return R.error(2001002, "链上数据读取为空");
        } catch (Exception e) {
            log.error("Fail to read chain data.", e);
            return R.ok(Verification.builder()
                    .pass(false)
                    .build());
        }
    }

    /**
     * 捐赠数据签名
     */
    private String signDonation(String donorName, String donorIdCard, String donateTime,
                                List<Map<String, Object>> detailMap) {
        return SignUtils.sign(donorName, donorIdCard, donateTime, detailMap);
    }

    /**
     * 受捐/领取数据签名
     */
    private String signDraw(String donatoryName, String donatoryIdCard, String donateTime,
                            List<Map<String, Object>> detailMap) {
        return SignUtils.sign(donatoryName, donatoryIdCard, donateTime, detailMap);
    }

}
