package com.gzw.future;

/**
 * 封装数据的实体
 * @author gzw
 *
 * @param <T>
 */
public class FutureData<T> implements Future<T>{
	
	private T t;
	
	public FutureData(T t) {
		this.t = t;
	}

	@Override
	public T get() {
		
		return t;
	}

}
