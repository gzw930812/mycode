package com.gzw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope 
public class TestController {

	@Value("${name}")
    private String name;
	@Value("${age}")
	private String age;

    @RequestMapping("/test")
    public String from() {
        return this.name +"..."+this.age;
    }
	
}
