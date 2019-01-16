package com.gzw.hystrix;

import org.springframework.stereotype.Component;

import com.gzw.feignclient.Remote;

@Component
public class Hystrix implements Remote{

	@Override
	public String hello2(String name) {
		
		return  "hello" +name+", this messge send failed ";
	}

}
