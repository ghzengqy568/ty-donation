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

import com.baidu.mapp.bcd.domain.Donor;
import com.baidu.mapp.bcd.domain.DonorExample;
import com.baidu.mapp.bcd.dto.UserThreadLocal;
import com.baidu.mapp.bcd.service.DonorService;

public class UserAuthFilter implements Filter {
    private final static String XTOKEN = "X-Token";

    private List<String> noAuths;

    private DonorService donorService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public UserAuthFilter(List<String> noAuths, DonorService donorService) {
        if (noAuths == null) {
            noAuths = new ArrayList<>();
        }
        this.noAuths = noAuths;
        this.donorService = donorService;
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
            Donor donor = donorService.selectOneByExample(
                    DonorExample.newBuilder().build().createCriteria().andLoginTokenEqualTo(xtoken).toExample());
            UserThreadLocal.addDonor(donor);
        }
        chain.doFilter(request, response);
        UserThreadLocal.removeDonor();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
