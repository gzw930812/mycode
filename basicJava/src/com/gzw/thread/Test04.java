package com.gzw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test04 {
public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			exec.execute(new TestThread1());
		}
		//停掉线程池
		exec.shutdown();
	}
}

class TestThread1 implements Runnable{
	
	//模拟出售的车票
	private static Integer count = 100;
	/**
	 * 
	 * 下面这种写法是错误的,会产生线程安全问题
	 * private static volatile  boolean true = true;
	 * while(flag){
	 * 		synchronized (count) {
				if(count <= 0){
					flag = false;
				}
	 * 
	 * }
	 * 
	 * 下面这种写法也是错误的,造成线程安全问题
	 * while(count>0){
	 * 	 synchronized (count) {
	 * 		...
	 * 	 }
	 * }
	 * 
	 */
	@Override
	public void run() {
		while(true){
			synchronized (count) {
				if(count == 0){
					return;
				}
				count--;
				int i = 100 - count;
				System.out.println(Thread.currentThread().getName()+"出售了第"+i+"张车票");
			}
			//注意：线程休眠不能写在同步代码块中，否则多线程操作可见性会受影响，造成线程安全问题
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
