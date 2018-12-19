package create.prototype.deep;

public class Person implements Cloneable{
	
	private String name;
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
	
	public Person clone() throws CloneNotSupportedException{
		
		return (Person) super.clone();
	}
}
