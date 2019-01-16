package com.gzw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/index")
	public String index(@RequestParam String name){
		
		return "hello "+name+"，this is first messge";
	}
	
}
