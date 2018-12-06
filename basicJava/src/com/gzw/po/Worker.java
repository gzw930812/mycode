package com.gzw.po;

import java.util.Date;

import com.gzw.annotation.XmlElement;
import com.gzw.util.DateUtils;

public class Worker {
	
	@XmlElement(name="NAME")
	private String name;
	@XmlElement(name="AGE",value="10")
	private int age;
	@XmlElement(name="HOBBY")
	private String hobby;
	@XmlElement(name="DATE")
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worker(String name, int age, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	
	
}
