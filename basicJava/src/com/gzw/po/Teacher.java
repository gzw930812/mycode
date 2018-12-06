package com.gzw.po;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.gzw.util.DataAdapter;
@XmlRootElement(name="ROW")
public class Teacher extends Row{
	@XmlElement(name="NAME")
	@XmlJavaTypeAdapter(value=DataAdapter.class)
	private String name;
	@XmlElement(name="AGE")
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}
	
}
