/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.Admin;
import com.baidu.mapp.bcd.domain.AdminExample;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonor;
import com.baidu.mapp.bcd.dto.CustomizedPair;
import com.baidu.mapp.bcd.dto.DonorReq;
import com.baidu.mapp.bcd.dto.LoginParam;
import com.baidu.mapp.bcd.dto.LoginResponse;
import com.baidu.mapp.bcd.service.AdminService;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonorService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Schema(description = "捐赠人接口")
@RestController
@RequestMapping("/donor")
public class DonorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DonorController.class);

    @Autowired
    DonorService donorService;

    @Autowired
    CertService certService;

    @Autowired
    Digest digest;

    @Autowired
    AdminService adminService;

    @PostMapping("register")
    public R<String> register(@RequestBody DonorReq donorReq) {

        String userName = donorReq.getUserName();
        if (StringUtils.isBlank(userName)) {
            return R.error(100101, "参数错误，用户名不能为空");
        }

        String password = donorReq.getPassword();
        if (StringUtils.isBlank(password)) {
            return R.error(100101, "参数错误，用户密码不能为空");
        }

        String name = donorReq.getName();
        if (StringUtils.isBlank(name)) {
            return R.error(100101, "参数错误，姓名不能为空");
        }

        Donor donorInDb = donorService.selectOneByExample(DonorExample.newBuilder()
                .build()
                .createCriteria()
                .andDonorUserNameEqualTo(userName)
                .toExample()
        );
        if (donorInDb != null) {
            return R.error(100102, "用户名已被占用");
        }
        String sign = SignUtils.sign(userName,name);
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());

        String idcard = donorReq.getIdcard();
        String mobile = donorReq.getMobile();
        try{
            idcard = digest.encryptDes(idcard);
            mobile = digest.encryptDes(mobile);
        }catch(Exception ex){
            LOGGER.error("digest error", ex);
        }

        Donor donor = Donor.newBuilder()
                .donorUserName(userName)
                .donorName(name)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .certCode("")
                .donorPwd(pwd)
                .sign(password)
                .idcard(idcard)
                .mobile(mobile)
                .build();

        donorService.insertSelective(donor);

        Long donorId = donor.getId();

        String certCode = certService.writeChain(donorId, MetaDonor.TABLE_NAME, donorId, sign);
        donor.setCertCode(certCode);
        donor.setLastModifyTime(new Date());
        donorService.updateByPrimaryKeySelective(donor);
        return R.ok(certCode);
    }

    @PostMapping("login")
    public R<LoginResponse> login(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        long now = System.currentTimeMillis()/1000L * 1000L;
        String mobile = loginParam.getMobile();
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(mobile) && StringUtils.isBlank(username)) {
            return R.error(100100, "用户名和手机号不能同时为空");
        }
        if (StringUtils.isBlank(password)) {
            return R.error(100100, "密码不能为空");
        }
        Donor donor = null;
        if (!StringUtils.isBlank(username)) {
            donor = donorService.selectOneByExample(
                    DonorExample.newBuilder().build().createCriteria().andDonorUserNameEqualTo(username).toExample());
        } else if (!StringUtils.isBlank(mobile)) {
            try{
                mobile = digest.encryptDes(mobile);
            }catch(Exception ex){
                LOGGER.error("digest error", ex);
            }
            donor = donorService.selectOneByExample(
                    DonorExample.newBuilder().build().createCriteria().andMobileEqualTo(mobile).toExample());
        }
        if (donor == null) {
            return R.error(100102, "用户不存在");
        }

        String encryptPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!StringUtils.equals(encryptPassword, donor.getDonorPwd())) {
            return R.error(100102, "密码错误");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(donor.getId());
        String token = UUID.randomUUID().toString();
        loginResponse.setToken(token);
        donor.setLoginToken(token);
        donor.setLastLoginTime(new Date());
        donor.setLastModifyTime(new Date());
        donorService.updateByPrimaryKeySelective(donor);

        return R.ok(loginResponse);

    }

    @PostMapping("adminLogin")
    public R<LoginResponse> adminLogin(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        long now = System.currentTimeMillis()/1000L * 1000L;
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(username)) {
            return R.error(100100, "用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return R.error(100100, "密码不能为空");
        }
        Admin admin = null;
        if (!StringUtils.isBlank(username)) {
            admin = adminService.selectOneByExample(
                    AdminExample.newBuilder().build().createCriteria().andAdminUserNameEqualTo(username).toExample());
        }
        if (admin == null) {
            return R.error(100102, "用户不存在");
        }

        String encryptPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!StringUtils.equals(encryptPassword, admin.getAdminPwd())) {
            return R.error(100102, "密码错误");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(admin.getId());
        String token = UUID.randomUUID().toString();
        loginResponse.setToken(token);
        admin.setLoginToken(token);
        admin.setLastLoginTime(new Date());
        admin.setLastModifyTime(new Date());
        adminService.updateByPrimaryKeySelective(admin);

        return R.ok(loginResponse);

    }

    @GetMapping("all")
    public R<List<CustomizedPair>> getAllDonarNames() {
        List<CustomizedPair> customizedPairs = new ArrayList<>();
        List<Donor> donors = donorService.selectAll();
        if (CollectionUtils.isEmpty(donors)) {
            return R.ok(customizedPairs);
        }
        donors.forEach((Donor d) -> {
            customizedPairs.add(CustomizedPair.builder()
                .label(d.getDonorName())
                .value(d.getId())
                .build());
        });
        return R.ok(customizedPairs);
    }


}
