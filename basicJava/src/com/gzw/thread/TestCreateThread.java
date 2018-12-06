package com.gzw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCreateThread {

	//主线程
	public static void main(String[] args) {
		//用户线程t1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		t1.start();
		
		//守护线程t2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			}
		});
		//设置为守护线程
		t2.setDaemon(true);
		t2.yield();
		t2.start();
	}
}

//第一种
class Thread1 extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	public static void main(String[] args) {
		new Thread1().start();
	}
	
}

//第二种
class Thread2 implements Runnable{

	@Override
	public void run() {
		
	}
	
	public static void main(String[] args) {
		new Thread(new Thread2()).start();
	}
	
}

//第三种
class Thread3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		return "";
	}
	
	public static void main(String[] args) {
		FutureTask<String> task = new FutureTask<>(new Thread3());
		new Thread(task).start();
	}
	
}
