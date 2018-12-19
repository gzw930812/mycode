package structure.proxy;

import structure.proxy.interface_.Manager;
import structure.proxy.jdk_cglib.CglibProxy;
import structure.proxy.jdk_cglib.JdkProxy;
import structure.proxy.static_.ManagerImplProxy;
import structure.proxy.target.ManagerImpl;

public class TestProxy {
	public static void main(String[] args) {
		//静态代理
		Manager manager = new ManagerImplProxy(new ManagerImpl());
		manager.saySome();
		
		JdkProxy proxy = new JdkProxy();
		Manager obj = (Manager) proxy.newProxyInstance(new ManagerImpl());
		obj.eatSome();
		obj.saySome();
		
		CglibProxy proxy2 = new CglibProxy();
		Manager obj2 = (Manager) proxy2.newProxyInstance(new ManagerImpl());
		obj2.eatSome();
		obj2.saySome();
	}
}
