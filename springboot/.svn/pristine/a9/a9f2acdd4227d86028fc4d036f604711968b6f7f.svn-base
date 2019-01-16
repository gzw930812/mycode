package com.cptech.common.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.cptech.App;

/**
 * war包部署需要
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
public class SpringBootSampleApplication extends SpringBootServletInitializer{

    //private static final Logger logger = LoggerFactory.getLogger(SpringBootSampleApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

}