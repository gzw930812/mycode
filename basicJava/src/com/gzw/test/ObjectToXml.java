package com.gzw.test;

import com.gzw.po.Student;
import com.gzw.util.XmlAndJavaObjectConvert;

public class ObjectToXml {
	
	
	public static void main(String[] args) {
		
		Student s = new Student();
//		s.setName("张三/");
		s.setAge(15);
		
		Student s2 = new Student("历史", 20);
		s.setStudent(s2);
		String str = XmlAndJavaObjectConvert.convertToXml(s,true);
		System.out.println(str);
	}

}
