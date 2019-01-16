package com.gzw;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumer {

	public static final String BROKER_URI = "tcp://127.0.0.1:61616";

	public static void main(String[] args) throws JMSException, IOException {
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
		// 5,创建主题
		Topic topic = session.createTopic("test-topic0");
		//6，创建消费者
		MessageConsumer consumer = session.createConsumer(topic);
		//7,设置消费者监听器
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message msg) {
				TextMessage txtmsg = (TextMessage) msg;
				try {
					System.out.println("接收到的topic消息："+txtmsg.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
				
			}
		});
		System.in.read();
		consumer.close();
		session.close();
		connect.close();
	}
}
