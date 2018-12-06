package com.gzw.newspecjdk8.lambda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.gzw.po.Student;
import com.gzw.po.Teacher;

public class TestMethodRefer {
	
	public static void main(String[] args) {
		
		BiConsumer<String, String> t = (s1,s2) -> System.out.println(s1+s2); 
		t.accept("hello ", "world");
		t.andThen(t).accept("hello ", "world");;
		Predicate< Integer> p = p1 -> {if(p1 == 1 ){return true;}else{return false;}};
		System.out.println(p.test(1));
		System.out.println(p.negate().test(1));
		System.out.println(p.and(p).test(1));
		Teacher r = new Teacher();
		Function<Student, Teacher> f = s -> r;
		
		Student s1 = new Student("zhangsan1", 18);
		Student s2 = new Student("zhangsan2", 19);
		Student s3 = new Student("zhangsan3", 20);
		Student s4 = new Student("zhangsan4", 15);
//		Student s = new Student();
		List<Student> list = Arrays.asList(s1,s2,s3,s4);
//		//list.sort((o1,o2) -> o1.getAge()-o2.getAge());
//		list.forEach(o1 -> System.out.println(o1.toString()));
//		System.out.println("**************");
//		//静态方法引用  类名::静态方法名
//		list.sort(Student :: compareStudentByScore);
		list.forEach(o1 -> System.out.println(o1.toString()));
//		System.out.println("----------------");
//		//实例方法引用   对象 ::实例方法
//		list.forEach(s :: printStudent);
		System.out.println("++++++++++++++++++");
//		//类引用实例方法 类名::实例方法
//		list.forEach(Student :: print);
//		
//		System.out.println(create(Student :: new));
		list.stream().filter(s -> {if(s.getAge() >15){return true;}else{return false;}})
		.forEach(s -> System.out.println(s));
		System.out.println("&&&&&&&&&&&&&&");
		list.stream().map(s -> {r.setAge(s.getAge());r.setName(s.getName());return r;})
		.filter(s -> {if(s.getAge()>15){return true;}else{return false;}})
		.forEach(s -> System.out.println(s));
		//stream()  串行流      parallelStream() 并行流
		
		
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	    ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
	    try {
			nashorn.eval("print('hahaha')");
			try {
				Object o = nashorn.eval(new FileReader("C:\\Users\\Administrator\\Desktop\\test.js"));
				System.out.println(o);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
	    System.out.println(LocalDateTime.now().get(ChronoField.SECOND_OF_DAY));
	    System.out.println(LocalTime.now());
	    try {
	    	  String base64encodedString = Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
	    	   System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
	    	   byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
	           System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
	           
	           base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
	           System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
	           System.out.println("lalal");
		} catch (Exception e) {
			
		}
	  
     
	}
	
	@FunctionalInterface
	interface Re<T>{
		T get();
	}

	public static Student create(Re<Student> r){
		return r.get();
	}	
}
