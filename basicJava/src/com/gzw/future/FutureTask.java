package com.gzw.future;

import java.util.concurrent.Callable;

public class FutureTask<T> {
	
	public Future<T> submit(T t){
		final FutureImpl<T> future = new FutureImpl<T>();
		//开线程跑任务
		new Thread(() -> {
			FutureData<T> data = new FutureData<>(t);
			future.set(data);
		}).start();
		return future;
	}
	
	//变体
	public Future<T> submit(Callable<T> callable){
		final FutureImpl<T> future = new FutureImpl<T>();
		//开线程跑任务
		new Thread(() -> {
			try {
				T t = callable.call();
				FutureData<T> data = new FutureData<>(t);
				future.set(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		return future;
	}

}
