/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.common.utils.SignUtils;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DonatoryExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.meta.MetaDonatory;
import com.baidu.mapp.bcd.dto.DonatoryReq;
import com.baidu.mapp.bcd.service.CertService;
import com.baidu.mapp.bcd.service.DonatoryService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "受捐人接口", name = "DonatoryController")
@RestController
@RequestMapping("/donatory")
public class DonatoryController {
    @Autowired
    CertService certService;

    @Autowired
    DonatoryService donatoryService;

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
        String sign = SignUtils.sign(userName,name);
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());

        Donatory donatory = Donatory.newBuilder()
                .donatoryUserName(userName)
                .donatoryName(name)
                .createTime(new Date())
                .lastModifyTime(new Date())
                .donatoryLevel(donatoryLevel)
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




}
