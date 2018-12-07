package com.gzw.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch  倒计时器
 * 等待其他线程完成任务后，当前线程在开始执行，会阻塞当前线程。
 * @author gzw
 *
 */
public class TestCountDownLatch {
	
	public static void main(String[] args) throws InterruptedException {
		//寻找7龙珠
		int num = 7;
		CountDownLatch latch = new CountDownLatch(num);
		System.out.println("开始出发寻找7龙珠。。。。");
		for (int i = 0; i < num; i++) {
			int index = i; 
			new Thread(() -> {
				System.out.println("找到第"+(index+1)+"龙珠");
				try {
					Thread.sleep(new Random().nextInt(3000));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
			}).start();
		}
		
		latch.await();
		System.out.println("七龙珠找齐了，召唤神龙。。。");
		
	}

}
