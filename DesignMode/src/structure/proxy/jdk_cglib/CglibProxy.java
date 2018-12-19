package structure.proxy.jdk_cglib;

import java.lang.reflect.Method;

import structure.proxy.interface_.Manager;
import structure.proxy.target.ManagerImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	public Object newProxyInstance(Object target){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ManagerImpl.class);
		enhancer.setCallback(new CglibProxy());
		Manager obj2 = (Manager) enhancer.create();
		return obj2;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib:开始。。。");
		methodProxy.invokeSuper(proxy, args);
		System.out.println("cglib:结束。。。");
		return null;
	}

}
