

package com.baidu.mapp.bcd.config;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.baidu.mapp.bcd.filter.CrossDomainFilter;
import com.baidu.mapp.bcd.service.DonorService;

/**
 * TODO NOTICE : WebMvcConfigurationSupport 接口会导致静态首页失效（addViewControllers），
 * 但是WebMvcConfigurerAdapter接口不会
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);
    private static final String CROSS_FILTER_NAME = "crossDomainFilter";
    private static final String USERAUTH_FILTER_NAME = "userAuthFilter";

    @Value("${bcd.noauths:axs}")
    private List<String> noAuths;

    @Autowired
    private DonorService donorService;

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

    @Bean
    public FilterRegistrationBean userAuthFilter() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("regist userAuthFilter FilterRegistrationBean filterName={}", USERAUTH_FILTER_NAME);
        }
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName(USERAUTH_FILTER_NAME);
        filterRegistrationBean.setFilter(new UserAuthFilter(noAuths, donorService));
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 101);
        return filterRegistrationBean;
    }
}
