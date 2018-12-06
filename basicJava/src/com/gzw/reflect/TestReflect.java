package com.gzw.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gzw.po.Student;
import com.gzw.po.Teacher;
/**
 * 
 * @author Administrator
 *通过反射可以获取：方法，属性，注解，构造器
 *
 *
 */
public class TestReflect {
	
	
	public static void main(String[] args) {
		Student s = new Student("张三", 18);
		//获取反射的三种方式
		try {
			Class clazz1 = Class.forName("com.gzw.po.Student");
			Class clazz2 = s.getClass();
			Class clazz3 = Student.class;
			
			//类全称
			System.out.println(clazz1.getName()+"..."+clazz2.getName()+"..."+clazz3.getName());
			//获取方法，属性
			System.out.println(Arrays.toString(clazz1.getMethods()));
			Method[] methods = clazz1.getMethods();
			
			for (Method method : methods) {
				System.out.println(method.getName());
			}
			Field[] fields = clazz1.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName()+"..."+field.getType().getSimpleName());
				
			}
			
			strListAndInteger();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过泛型越过String类型检查
	 */
	public static void strListAndInteger(){
		List<String> strList = new ArrayList<String>();
		strList.add("aaa");
		strList.add("bbb");
		Class clazz = strList.getClass();
		try {
			Method m = clazz.getMethod("add", Object.class);
			m.invoke(strList, 100);
			System.out.println(strList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Student> stus = new ArrayList<>();
		stus.add(new Student("lisi", 20));
		stus.add(new Student("wangwu", 10));
		Class stuClazz = stus.getClass();
		try {
			Method m = stuClazz.getMethod("add", Object.class);
			m.invoke(stus, new Teacher("laoshi", 15));
			System.out.println(stus);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
