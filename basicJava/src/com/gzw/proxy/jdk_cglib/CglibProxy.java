package com.gzw.proxy.jdk_cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib:开始。。。");
		methodProxy.invokeSuper(proxy, args);
		System.out.println("cglib:结束。。。");
		return null;
	}

}
