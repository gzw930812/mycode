package com.gzw.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者、消费者、队列demo
 * 
 * @author gzw
 *
 */
public class Test02 {

	public static void main(String[] args) {
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);
		Thread producer = new Thread(new Producer(blockingQueue));
		//Thread consumer = new Thread(new Consumer(blockingQueue));
		producer.start();
		//consumer.start();

	}

}
//消费者
class Consumer implements Runnable {
	// 阻塞队列
	private BlockingQueue<String> blockingQueue;
	public Consumer(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		try {
			while(true){
				String result = blockingQueue.poll(2, TimeUnit.SECONDS);
				if(null == result){
					break;
				}
				System.out.println("消费者："+result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("消费者线程结束。。。");
	}
	
}
//生产者
class Producer implements Runnable {
	// 阻塞队列
	private BlockingQueue<String> blockingQueue;
	// 计数器
	private AtomicInteger atomicInteger = new AtomicInteger();
	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		try {
			while (true) {
				String shu = atomicInteger.getAndIncrement() + "";
				boolean flag = blockingQueue.offer(shu, 2, TimeUnit.SECONDS);
				if(!flag){
					break;
				}
				System.out.println("生产者："+shu);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产线程结束。。。。。");
	}

}
