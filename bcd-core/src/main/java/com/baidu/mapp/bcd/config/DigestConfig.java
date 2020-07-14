/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baidu.mapp.bcd.common.utils.digest.Digest;

@Configuration
public class DigestConfig {

    @Value("${bcd.slat:donate0192837465}")
    private String slat;

    @Bean
    public Digest digest() {
        return Digest.getInstance(slat);
    }

}
