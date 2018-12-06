package com.gzw.proxy.static_;

import com.gzw.proxy.interface_.Manager;
import com.gzw.proxy.target.ManagerImpl;

public class ManagerImplProxy implements Manager{
	
	private ManagerImpl managerImpl;
	
	

	public ManagerImplProxy(ManagerImpl managerImpl) {
		super();
		this.managerImpl = managerImpl;
	}

	@Override
	public void saySome() {
		System.out.println("开始说。。。");
		managerImpl.saySome();
		System.out.println("说完了。。。");
		
	}

	@Override
	public void eatSome() {
		System.out.println("开始吃。。。");
		managerImpl.eatSome();
		System.out.println("吃完了。。。");
	}
	
}
