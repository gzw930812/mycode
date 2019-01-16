package com.gzw.activemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ActiveMqProducer {

	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	Queue queue;
	
	private static int num = 1;
	
	@Scheduled(fixedDelay = 2000) //每2s执行
	public void sendMsg(){
		this.jmsMessagingTemplate.convertAndSend(this.queue, "第"+num+"条消息。。。");
		num++;
	}
	
}
