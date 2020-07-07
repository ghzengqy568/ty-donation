/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.config;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.smile.MappingJackson2SmileHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.baidu.mapp.bcd.common.gson.GsonFactory;
import com.google.gson.Gson;

@Configuration
// 不能与swagger ui共存
// springfox.documentation.swagger2.web.Swagger2Controller.getDocumentation转换有问题
public class GsonHttpMessageConverterMvcConfig implements WebMvcConfigurer {
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (!CollectionUtils.isEmpty(converters)) {
            Gson gson = GsonFactory.createGson();
            GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter(gson);
            gsonHttpMessageConverter
                    .setSupportedMediaTypes(Arrays.asList(
                            MediaType.APPLICATION_JSON_UTF8,
                            MediaType.TEXT_HTML,
                            // https://blog.csdn.net/ccor2002/article/details/104697202/
                            MediaType.valueOf("application/vnd.spring-boot.actuator.v3+json"),
                            MediaType.valueOf("application/vnd.spring-boot.actuator.v2+json"),
                            MediaType.valueOf("application/vnd.spring-boot.actuator.v1+json")

                    ));
            converters.add(gsonHttpMessageConverter);

            Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
            while (iterator.hasNext()) {
                HttpMessageConverter<?> next = iterator.next();
                if (next instanceof MappingJackson2HttpMessageConverter) {
                    iterator.remove();
                } else if (next instanceof MappingJackson2SmileHttpMessageConverter) {
                    iterator.remove();
                } else if (next instanceof MappingJackson2CborHttpMessageConverter) {
                    iterator.remove();
                }
            }
        }
    }
}
