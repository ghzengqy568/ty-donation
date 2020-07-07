

package com.baidu.mapp.bcd.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.baidu.mapp.bcd.filter.CrossDomainFilter;

/**
 * TODO NOTICE : WebMvcConfigurationSupport 接口会导致静态首页失效（addViewControllers），
 * 但是WebMvcConfigurerAdapter接口不会
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);
    private static final String CROSS_FILTER_NAME = "crossDomainFilter";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public FilterRegistrationBean crossDomainFilter() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("注册CrossDomainFilter FilterRegistrationBean filterName={}", CROSS_FILTER_NAME);
        }
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName(CROSS_FILTER_NAME);
        filterRegistrationBean.setFilter(new CrossDomainFilter());
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}
