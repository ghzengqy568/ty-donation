/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${bcd.rest-template.connect-timeout: 5000}")
    private int connectTimeout = 5000;

    @Value("${bcd.rest-template.read-timeout: 15000}")
    private int readTimeout = 15000;

    @Bean("restSimpleClientHttpRequestFactory")
    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        return requestFactory;
    }

    @Bean("restTemplate")
    public RestTemplate fetchRestTemplate(@Autowired @Qualifier("restSimpleClientHttpRequestFactory")
                                                  SimpleClientHttpRequestFactory restSimpleClientHttpRequestFactory) {

        RestTemplate template = new RestTemplate(restSimpleClientHttpRequestFactory);

        List<HttpMessageConverter<?>> messageConverters = template.getMessageConverters();
        for (HttpMessageConverter<?> messageConverter : messageConverters) {
            if (messageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) messageConverter).setDefaultCharset(Charset.forName("utf-8"));
            }
        }

        return template;
    }
}

