package com.dz.test;

public class Test {
	
	
	public static void main(String[] args) {
		Student s = new Student();
		s.setName("张三");
		System.out.println(XStreamUtil.bean2Xml(s));
	}
}
