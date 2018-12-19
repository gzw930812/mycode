package structure.proxy.target;

import structure.proxy.interface_.Manager;


public class ManagerImpl implements Manager{

	@Override
	public void saySome() {
		System.out.println("saySome:说说说！！！");
	}

	@Override
	public void eatSome() {
		System.out.println("eatSome:吃吃吃！！！");
	}

}
