package com.gzw.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
/**
 * 
 * @author gzw
 *
 */
public class TestCyclicBarrier {

	public static void main(String[] args) throws InterruptedException {
		// 寻找7龙珠
		int num = 7;
		//设置屏障点
		CyclicBarrier cb = new CyclicBarrier(num,new Runnable() {
			@Override
			public void run() {
				System.out.println("集齐7颗龙珠。。。召唤神龙");
			}
		});
		System.out.println("开始出发寻找7龙珠。。。。");
		for (int i = 0; i < num; i++) {
			int index = i;
			new Thread(() -> {
				System.out.println("找到第" + (index + 1) + "龙珠");
				try {
					Thread.sleep(new Random().nextInt(3000));
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

}
