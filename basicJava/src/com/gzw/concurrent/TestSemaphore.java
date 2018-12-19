package com.gzw.concurrent;

import java.util.concurrent.Semaphore;
/**
 * 
 * @author gzw
 *
 */
public class TestSemaphore {
	
	public static void main(String[] args) {
		//5台机器
		Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < 7; i++) {
			int num =i;
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println("第"+num+"个工人占用机器");
					Thread.sleep(2000);
					System.out.println("第"+num+"个工人释放机器");
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
			
		}
	}

}
