package create.prototype.simple.clone;

import create.prototype.Person;


public class Protype2 implements Cloneable{
	
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	/**
	 * 浅克隆
	 */
	public Protype2 clone(){
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException  e) {
			e.printStackTrace();
		}
		return (Protype2) clone;
		
		
	}

}
