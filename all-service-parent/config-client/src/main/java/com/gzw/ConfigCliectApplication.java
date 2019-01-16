package com.gzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ConfigCliectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigCliectApplication.class, args);
	}

}
