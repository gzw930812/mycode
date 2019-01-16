package com.cptech.common.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Configuration
public class ThymeleafViewConfig {
	private static ThymeleafViewResolver viewResolver;
    
    @Value("${cptech.fileServerAddress}")
    private void setFileServer(String fileServer) {
    	setVariables("fileServer", fileServer);
    }
    
    private void setVariables(String key , Object value) {
    	if(viewResolver != null)
    		viewResolver.addStaticVariable(key, value);
    }
    @Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
    	ThymeleafViewConfig.viewResolver = viewResolver;
    }
}
