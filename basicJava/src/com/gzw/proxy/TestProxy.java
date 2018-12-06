package com.gzw.proxy;

import net.sf.cglib.proxy.Enhancer;

import com.gzw.proxy.interface_.Manager;
import com.gzw.proxy.jdk_cglib.CglibProxy;
import com.gzw.proxy.jdk_cglib.JdkProxy;
import com.gzw.proxy.static_.ManagerImplProxy;
import com.gzw.proxy.target.ManagerImpl;

public class TestProxy {
	public static void main(String[] args) {
		//静态代理
		Manager manager = new ManagerImplProxy(new ManagerImpl());
		manager.saySome();
		
		JdkProxy proxy = new JdkProxy();
		Manager obj = (Manager) proxy.newProxyInstance(new ManagerImpl());
		obj.eatSome();
		obj.saySome();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ManagerImpl.class);
		enhancer.setCallback(new CglibProxy());
		Manager obj2 = (Manager) enhancer.create();
		obj2.eatSome();
		obj2.saySome();
	}
}
