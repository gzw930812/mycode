package com.gzw.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test05 {
	
	public static void main(String[] args) {
		//ArrayBlockingQueue<E>
		Executor exec1 = Executors.newCachedThreadPool(); //使用队列：SynchronousQueue
		Executor exec2 = Executors.newFixedThreadPool(5); //LinkedBlockingQueue
		Executor exec3 = Executors.newScheduledThreadPool(3);//DelayedWorkQueue
		Executor exec4 = Executors.newSingleThreadExecutor();//LinkedBlockingQueue
		
		/**
		 * 线程池工作原理
		 * If fewer than corePoolSize threads are running, the Executor always prefers adding a new thread 
		 * rather than queuing.
		 * If corePoolSize or more threads are running, the Executor always prefers queuing a request rather 
		 * than adding a new thread.
		 * If a request cannot be queued, a new thread is created unless this would exceed 
		 * maximumPoolSize, in which case, the task will be rejected.
		 */
		new ThreadPoolExecutor( 5,//corePoolSize, 核心线程池大小
				Runtime.getRuntime().availableProcessors(),//maximumPoolSize 最多能容纳多少线程数
				10,//keepAliveTime 线程空闲时间 
				TimeUnit.SECONDS, //时间单位 
				new LinkedBlockingDeque<Runnable>(512),//workQueue 阻塞队列 
				new ThreadFactory() {
					
					@Override
					public Thread newThread(Runnable r) {
						return new Thread(r);
					}
				}, //线程创建方式
				new ThreadPoolExecutor.DiscardPolicy());//handler拒绝策略);
		
	}

}

