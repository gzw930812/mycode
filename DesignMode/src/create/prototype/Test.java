package create.prototype;

import java.util.Date;

public class Test {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Student s = new Student();
		s.setName("张飞");
		s.setAge(15);
		s.setSchoolName(new StringBuilder("高中"));
		s.setBirth(new Date(100, 9, 20));
		Teacher t = new Teacher();
		t.setName("诸葛");
		s.setTeacher(t);
		Student ps = s.clone();
		
		ps.setBirth(new Date());
		ps.setAge(20);
		ps.setSchoolName(new StringBuilder("大学"));
		ps.setName("李四");
		ps.getTeacher().setName("王五");
		System.out.println(s.getBirth());
		System.out.println(ps.getBirth());
		
		
	}

}

class Student implements Cloneable{
	
	private String name;
	private StringBuilder schoolName;
	private Integer age;
	private Teacher teacher;
	private Date birth;
	
	public StringBuilder getSchoolName() {
		return schoolName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setSchoolName(StringBuilder schoolName) {
		this.schoolName = schoolName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Student clone() throws CloneNotSupportedException {
		Student s = (Student) super.clone();
		//s.teacher = teacher.clone();
		return s;
	}
}

class Teacher implements Cloneable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Teacher clone() throws CloneNotSupportedException {
		
		return (Teacher) super.clone();
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + "]";
	}
	
}