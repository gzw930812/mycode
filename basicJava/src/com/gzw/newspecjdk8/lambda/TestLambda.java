package com.gzw.newspecjdk8.lambda;

import java.util.Arrays;

public class TestLambda {
	public static void main(String[] args) {
		//常用的lambda表达式
		new Thread(() -> System.out.println("新启线程")).start();;
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
		A a = () -> System.out.println("我是A接口的a方法");
		a.a();
		A.aaa();
	}
}

//表明该接口为函数式接口  常见函数式接口：java.lang.Runnable 和java.util.concurrent.Callable
@FunctionalInterface
interface A{
	void a();
	//default 默认方法，可以不被子类实现，子类可以继承可以重新，不影响函数式编程(jdk8引入)
	default void aa(){
		System.out.println("默认方法！");
	}
	
	//静态方法 
	static void aaa(){
		System.out.println("静态方法");
	}
}
