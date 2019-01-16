package com.gzw;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringbootMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMqApplication.class, args);
	}
	
	@Bean
	public ActiveMQQueue queue(){
		return new ActiveMQQueue("test01");
	}

}

