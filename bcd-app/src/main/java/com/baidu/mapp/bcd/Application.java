package com.baidu.mapp.bcd;

import org.apache.logging.log4j.core.async.AsyncLoggerContextSelector;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.baidu.mapp.bcd"})
@MapperScan(annotationClass = org.apache.ibatis.annotations.Mapper.class, basePackages = "com.baidu.mapp.bcd.dao")
@EnableTransactionManagement
@EnableScheduling
public class Application {
    static {
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        LOGGER.info("is async logger: {}", AsyncLoggerContextSelector.isSelected());
        System.out.println("is async logger: " + AsyncLoggerContextSelector.isSelected());
        new SpringApplicationBuilder()
                .sources(Application.class)
                .web(WebApplicationType.SERVLET)
                .registerShutdownHook(true)
                .build().run(args);
    }

}
