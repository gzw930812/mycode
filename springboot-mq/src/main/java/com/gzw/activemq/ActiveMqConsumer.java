package com.gzw.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqConsumer {
	
	@JmsListener(destination = "test01")
	public void reciverMsg(String msg){
		System.out.println("消费："+msg);
		
	}
	
	
}
