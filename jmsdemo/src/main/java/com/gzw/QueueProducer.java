package com.gzw;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueProducer {
	public static final String BROKER_URI = "tcp://127.0.0.1:61616";
	
	

	public static void main(String[] args) throws JMSException {
		
		// 1，创建连接工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URI);
		// 2，获取连接
		Connection connect = factory.createConnection();
		// 3,启动连接
		connect.start();
		/*
		 * 4.获取session (参数1：是否启动事务, 参数2：消息确认模式[ AUTO_ACKNOWLEDGE = 1 自动确认
		 * CLIENT_ACKNOWLEDGE = 2 客户端手动确认 DUPS_OK_ACKNOWLEDGE = 3 自动批量确认
		 * SESSION_TRANSACTED = 0 事务提交并确认 ])
		 */
		Session session = connect
				.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5创建队列对象
		Queue queue = session.createQueue("test-queue0");
		// 6,创建消息生产者
		MessageProducer producer = session.createProducer(queue);
		// 创建消息
		Message msg = session.createTextMessage("hello,JMS!!!");
		producer.send(msg);
		producer.close();
		session.close();
		connect.close();

	}

}
