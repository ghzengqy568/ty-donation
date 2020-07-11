/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.common.utils.DateTimeUtils;
import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonateDetail;
import com.baidu.mapp.bcd.dto.DonorReq;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonorService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "捐赠人接口")
@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    DonorService donorService;

    @Autowired
    CertService certService;

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
        Donor donor = Donor.newBuilder()
                .donorUserName(userName)
                .donorName(name)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .certCode("")
                .donorPwd(pwd)
                .sign(password)
                .build();

        donorService.insertSelective(donor);

        Long donorId = donor.getId();

        String certCode = certService.writeChain(donorId, MetaDonateDetail.TABLE_NAME, donorId, sign);
        donor.setCertCode(certCode);
        donor.setLastModifyTime(new Date());
        donorService.updateByPrimaryKeySelective(donor);
        return R.ok(certCode);
    }



}
