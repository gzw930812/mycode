package com.gzw.future;

/**
 * 异步获取数据的具体实现
 * @author gzw
 *
 * @param <T>
 */
public class  FutureImpl<T> implements Future<T>{
	
	//包装数据的对象
	private FutureData<T> data;
	private boolean flag = false;
	
	//设置数据方法 设置好后，通知get()方法
	public synchronized void set(FutureData<T> data){
		if(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		flag = true;
		this.data = data;
		notify();
	}
	
	//获取数据，若数据没设置好，等待。。。
	@Override
	public synchronized T get() {
		
		if(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		return data.get();
	}
}
