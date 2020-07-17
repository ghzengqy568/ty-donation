/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.domain.Admin;
import com.baidu.mapp.bcd.domain.AdminExample;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.domain.dto.UserType;
import com.baidu.mapp.bcd.dto.LoginParam;
import com.baidu.mapp.bcd.dto.LoginResponse;
import com.baidu.mapp.bcd.service.AdminService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "工作人相关接口")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("adminLogin")
    public R<LoginResponse> adminLogin(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        long now = System.currentTimeMillis()/1000L * 1000L;
        String username = loginParam.getUserName();
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
        String token = UserType.ADMIN.getName().concat(":").concat(UUID.randomUUID().toString());
        loginResponse.setToken(token);
        loginResponse.setName(admin.getAdminName());
        loginResponse.setUserName(admin.getAdminUserName());
        admin.setLoginToken(token);
        admin.setLastLoginTime(new Date());
        admin.setLastModifyTime(new Date());
        adminService.updateByPrimaryKeySelective(admin);

        return R.ok(loginResponse);

    }
}
