package com.gzw.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gzw.hystrix.Hystrix;

@FeignClient(name="service-producer2",fallback=Hystrix.class)
public interface Remote {
	
	@RequestMapping(value = "/index")
    public String hello2(@RequestParam(value = "name") String name);

}
