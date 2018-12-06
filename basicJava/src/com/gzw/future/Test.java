package com.gzw.future;

import java.util.concurrent.Callable;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("进入主线程。。。");
		FutureTask<String> task = new FutureTask<>();
		Future<String> future = task.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("获取数据中。。。。");
				//模拟获取数据过程的耗时操作
				Thread.sleep(3000);
				System.out.println("获取数据完成。。。");
				return "龚志威";
			}
		});
		System.out.println("主线程其他任务。。。。");
		String result = future.get();
		System.out.println(result);
		
	}

}
