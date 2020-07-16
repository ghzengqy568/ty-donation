/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

import com.baidu.mapp.bcd.domain.Admin;
import com.baidu.mapp.bcd.domain.AdminExample;
import com.baidu.mapp.bcd.domain.Donatory;
import com.baidu.mapp.bcd.domain.DonatoryExample;
import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.domain.dto.LoginUser;
import com.baidu.mapp.bcd.domain.dto.UserThreadLocal;
import com.baidu.mapp.bcd.domain.dto.UserType;
import com.baidu.mapp.bcd.service.AdminService;
import com.baidu.mapp.bcd.service.DonatoryService;
import com.baidu.mapp.bcd.service.DonorService;

public class UserAuthFilter implements Filter {
    private final static String XTOKEN = "X-Token";

    private List<String> noAuths;

    private DonorService donorService;

    private DonatoryService donatoryService;

    private AdminService adminService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public UserAuthFilter(List<String> noAuths, DonorService donorService, DonatoryService donatoryService, AdminService adminService) {
        if (noAuths == null) {
            noAuths = new ArrayList<>();
        }
        this.noAuths = noAuths;
        this.donorService = donorService;
        this.donatoryService = donatoryService;
        this.adminService = adminService;
    }

    public boolean noAuth(String uri) {
        for (String noAuth : noAuths) {
            boolean match = antPathMatcher.match(noAuth, uri);
            if (match) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String xtoken = httpServletRequest.getHeader(XTOKEN);
        if (StringUtils.isNotBlank(xtoken)) {
            if (UserType.isDonorToken(xtoken)) {
                Donor donor = donorService.selectOneByExample(
                        DonorExample.newBuilder().build().createCriteria().andLoginTokenEqualTo(xtoken).toExample());
                if (donor != null) {
                    UserThreadLocal.addLoginUser(LoginUser.builder()
                            .userId(donor.getId())
                            .name(donor.getDonorName())
                            .userName(donor.getDonorUserName())
                            .token(xtoken)
                            .userType(UserType.DONOR)
                            .build());
                }
            } else if (UserType.isDonatoryToken(xtoken)) {
                Donatory donatory = donatoryService.selectOneByExample(
                        DonatoryExample.newBuilder().build().createCriteria().andLoginTokenEqualTo(xtoken).toExample());
                if (donatory != null) {
                    UserThreadLocal.addLoginUser(LoginUser.builder()
                            .userId(donatory.getId())
                            .name(donatory.getDonatoryName())
                            .userName(donatory.getDonatoryUserName())
                            .token(xtoken)
                            .userType(UserType.DONATORY)
                            .build());
                }
            } else if (UserType.isAdminToken(xtoken)) {
                Admin admin = adminService.selectOneByExample(
                        AdminExample.newBuilder().build().createCriteria().andLoginTokenEqualTo(xtoken).toExample());
                if (admin != null) {
                    UserThreadLocal.addLoginUser(LoginUser.builder()
                            .userId(admin.getId())
                            .name(admin.getAdminName())
                            .userName(admin.getAdminUserName())
                            .token(xtoken)
                            .userType(UserType.ADMIN)
                            .build());
                }
            }
        }
        chain.doFilter(request, response);
        UserThreadLocal.removeLoginUser();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
