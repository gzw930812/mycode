package com.gzw.po;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="Stdent")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3738724663374396215L;
	
	private String name;
	private Integer age;
	private Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	public static int compareStudentByScore(Student student1,Student student2){
        return student1.getAge() - student2.getAge();
    }
	
	public void printStudent(Student s){
		System.out.println(s);
	}
	
	public void print(){
		System.out.println(this);
	}

}
