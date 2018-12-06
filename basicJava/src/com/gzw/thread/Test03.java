package com.gzw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author gzw
 *
 */
public class Test03 {

	
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			exec.execute(new TestThread());
		}
	}
}

class TestThread implements Runnable{
	
	//模拟出售的车票
	private static Integer count = 100;
	@Override
	public void run() {
		while(true){
			if(count == 0){
				return;
			}
			sale();
			int i = 100 - count;
			System.out.println(Thread.currentThread().getName()+"出售了第"+i+"张车票");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized void sale(){
		if(count > 0){
			count--;
		}
	}
	
}
