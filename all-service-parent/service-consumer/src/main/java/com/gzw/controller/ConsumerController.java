package com.gzw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzw.feignclient.Remote;

@RestController
public class ConsumerController {

	@Autowired
	Remote remote;
	
	@RequestMapping("/index/{name}")
	public String index(@PathVariable("name") String name){
		return remote.hello(name);
	}
	
	
}
