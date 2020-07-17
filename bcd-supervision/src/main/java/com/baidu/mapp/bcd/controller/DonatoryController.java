/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Assign;
import com.baidu.mapp.bcd.domain.AssignExample;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DonatoryExample;
import com.baidu.mapp.bcd.domain.DrawRecordFlow;
import com.baidu.mapp.bcd.domain.DrawRecordFlowExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.dto.LoginUser;
import com.baidu.mapp.bcd.domain.dto.UserThreadLocal;
import com.baidu.mapp.bcd.domain.dto.UserType;
import com.baidu.mapp.bcd.domain.meta.MetaAssign;
import com.baidu.mapp.bcd.domain.meta.MetaDonatory;
import com.baidu.mapp.bcd.domain.meta.MetaDrawRecordFlow;
import com.baidu.mapp.bcd.dto.CustomizedPair;
import com.baidu.mapp.bcd.dto.DonatoryActivityRes;
import com.baidu.mapp.bcd.dto.DonatoryReq;
import com.baidu.mapp.bcd.dto.LoginParam;
import com.baidu.mapp.bcd.dto.LoginResponse;
import com.baidu.mapp.bcd.service.ActivityService;
import com.baidu.mapp.bcd.service.AssignService;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonatoryService;
import com.baidu.mapp.bcd.service.DrawRecordFlowService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "受捐人接口", name = "DonatoryController")
@RestController
@RequestMapping("/donatory")
public class DonatoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DonatoryController.class);

    @Autowired
    CertService certService;

    @Autowired
    DonatoryService donatoryService;

    @Autowired
    Digest digest;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private AssignService assignService;

    @Autowired
    private DrawRecordFlowService drawRecordFlowService;

    @GetMapping("all")
    public R<List<CustomizedPair>> getAllDonarNames() {
        List<CustomizedPair> customizedPairs = new ArrayList<>();
        List<Donatory> donors = donatoryService.selectAll();
        if (CollectionUtils.isEmpty(donors)) {
            return R.ok(customizedPairs);
        }
        donors.forEach((Donatory d) -> {
            customizedPairs.add(CustomizedPair.builder()
                    .label(d.getDonatoryName())
                    .value(d.getId())
                    .build());
        });
        return R.ok(customizedPairs);
    }

    @PostMapping("add")
    public R<String> register(@RequestBody DonatoryReq donatoryReq) {

        String userName = donatoryReq.getUserName();
        if (StringUtils.isBlank(userName)) {
            return R.error(100101, "参数错误，用户名不能为空");
        }

        String password = donatoryReq.getPassword();
        if (StringUtils.isBlank(password)) {
            return R.error(100101, "参数错误，用户密码不能为空");
        }

        String name = donatoryReq.getName();
        if (StringUtils.isBlank(name)) {
            return R.error(100101, "参数错误，姓名不能为空");
        }
        Byte donatoryLevel = donatoryReq.getDonatoryLevel();
        if (donatoryLevel == null || donatoryLevel <= 0) {
            return R.error(100101, "参数错误，等级不能为空");
        }

        Donatory donatoryInDb = donatoryService.selectOneByExample(DonatoryExample.newBuilder()
                .build()
                .createCriteria()
                .andDonatoryUserNameEqualTo(userName)
                .toExample()
        );
        if (donatoryInDb != null) {
            return R.error(100102, "用户名已被占用");
        }
        String sign = SignUtils.sign(userName, name);
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());

        String idcard = donatoryReq.getIdcard();
        String mobile = donatoryReq.getMobile();
        try {
            idcard = digest.encryptDes(idcard);
            mobile = digest.encryptDes(mobile);
            if (StringUtils.isNotBlank(idcard)) {
                Donatory donatory =
                        donatoryService.selectOneByExample(DonatoryExample.newBuilder().build().createCriteria()
                                .andIdcardEqualTo(idcard)
                                .toExample());
                if (donatory != null) {
                    return R.ok("身份证号已存在");
                }
            }
            if (StringUtils.isNotBlank(mobile)) {
                Donatory donatory =
                        donatoryService.selectOneByExample(DonatoryExample.newBuilder().build().createCriteria()
                                .andMobileEqualTo(mobile)
                                .toExample());
                if (donatory != null) {
                    return R.ok("手机号已存在");
                }
            }
        } catch (Exception ex) {
            LOGGER.error("digest error", ex);
        }
        Donatory donatory = Donatory.newBuilder()
                .donatoryUserName(userName)
                .donatoryName(name)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .donatoryLevel(donatoryLevel)
                .idcard(idcard)
                .mobile(mobile)
                .donatoryCard(donatoryReq.getDonatoryCard())
                .province(donatoryReq.getProvince())
                .city(donatoryReq.getCity())
                .address(donatoryReq.getAddress())
                .certCode("")
                .donatoryPwd(pwd)
                .sign(password)
                .build();

        donatoryService.insertSelective(donatory);

        Long donatoryId = donatory.getId();

        String certCode = certService.writeChain(donatoryId, MetaDonatory.TABLE_NAME, donatoryId, sign);
        donatory.setCertCode(certCode);
        donatory.setLastModifyTime(new Date());
        donatoryService.updateByPrimaryKeySelective(donatory);
        return R.ok(certCode);
    }

    @PostMapping("login")
    public R<LoginResponse> login(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        String mobile = loginParam.getMobile();
        String username = loginParam.getUserName();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(mobile) && StringUtils.isBlank(username)) {
            return R.error(100100, "用户名和手机号不能同时为空");
        }
        if (StringUtils.isBlank(password)) {
            return R.error(100100, "密码不能为空");
        }
        Donatory donatory = null;
        if (!StringUtils.isBlank(username)) {
            donatory = donatoryService.selectOneByExample(
                    DonatoryExample.newBuilder().build().createCriteria().andDonatoryUserNameEqualTo(username)
                            .toExample());
        } else if (!StringUtils.isBlank(mobile)) {
            try {
                mobile = digest.encryptDes(mobile);
            } catch (Exception ex) {
                LOGGER.error("digest error", ex);
            }
            donatory = donatoryService.selectOneByExample(
                    DonatoryExample.newBuilder().build().createCriteria().andMobileEqualTo(mobile).toExample());
        }
        if (donatory == null) {
            return R.error(100102, "用户不存在");
        }

        String encryptPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!StringUtils.equals(encryptPassword, donatory.getDonatoryPwd())) {
            return R.error(100102, "密码错误");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(donatory.getId());
        String token = UserType.DONATORY.getName().concat(":").concat(UUID.randomUUID().toString());
        loginResponse.setToken(token);
        loginResponse.setName(donatory.getDonatoryName());
        loginResponse.setUserName(donatory.getDonatoryUserName());
        donatory.setLoginToken(token);
        donatory.setLastLoginTime(new Date());
        donatory.setLastModifyTime(new Date());
        donatoryService.updateByPrimaryKeySelective(donatory);
        return R.ok(loginResponse);
    }

    @GetMapping("myActivities")
    public R<List<DonatoryActivityRes>> myActivities(@RequestHeader("X-TOKEN") String xtoken,
                                                     @RequestParam(value = "drawStatus", required = false)
                                                             Byte drawStatus) {
        LoginUser loginUser = UserThreadLocal.getLoginUser();
        if (loginUser == null) {
            return R.error(100102, "你尚未登录");
        }
        UserType userType = loginUser.getUserType();
        if (userType == null || !userType.isDonatory()) {
            return R.error(100102, "你无权访问");
        }

        // 参与的活动
        Long donatoryId = loginUser.getUserId();
        List<Long> activityIdList = assignService.selectByExample(AssignExample.newBuilder()
                        .distinct(true)
                        .build()
                        .createCriteria()
                        .andDonatoryIdEqualTo(donatoryId)
                        .toExample(),
                Assign :: getActivityId,
                MetaAssign.COLUMN_NAME_ACTIVITYID
        );

        if (CollectionUtils.isEmpty(activityIdList)) {
            return R.ok(new ArrayList<>());
        }

        // 已领取的活动
        Map<Long, DrawRecordFlow> activityDrawMap =
                drawRecordFlowService.selectMapByExample(DrawRecordFlowExample.newBuilder().
                                build()
                                .createCriteria()
                                .andActivityIdIn(activityIdList)
                                .andDonatoryIdEqualTo(donatoryId)
                                .toExample(),
                        DrawRecordFlow :: getActivityId,
                        MetaDrawRecordFlow.COLUMN_NAME_ID,
                        MetaDrawRecordFlow.COLUMN_NAME_ACTIVITYID,
                        MetaDrawRecordFlow.COLUMN_NAME_CERTCODE
                );

        Map<Long, DrawRecordFlow> factivityDrawMap = activityDrawMap == null ? new HashMap<>() : activityDrawMap;

        List<DonatoryActivityRes> donatoryActivityRes = activityService.selectByPrimaryKeys(activityIdList, item ->
                DonatoryActivityRes.builder()
                        .activityId(item.getId())
                        .certCode(factivityDrawMap.get(item.getId()) != null ?
                                factivityDrawMap.get(item.getId()).getCertCode() : "")
                        .description(item.getDescription())
                        .startTime(item.getStartTime())
                        .drawStatus(factivityDrawMap.containsKey(item.getId()) ? (byte) 1 : (byte) 0)
                        .endTime(item.getEndTime())
                        .status(item.getStatus())
                        .donatoryId(donatoryId)
                        .theme(item.getTheme())
                        .build()
        );
        if (drawStatus != null && !donatoryActivityRes.isEmpty()) {
            donatoryActivityRes =
                    donatoryActivityRes.stream().filter(item -> item.getDrawStatus().equals(drawStatus))
                            .collect(Collectors.toList());
        }
        return R.ok(donatoryActivityRes);
    }
}
