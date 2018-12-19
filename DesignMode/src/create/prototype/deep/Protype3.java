package create.prototype.deep;

import create.prototype.Person;

public class Protype3 {
	
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	/**
	 * 最笨的深克隆
	 */
	public Protype3 clone(){
		Person p = new Person();
		p.setName(this.person.getName());
		p.setAge(this.person.getAge());
		Protype3 protype3 = new Protype3();
		protype3.setPerson(p);
		return protype3;
	}
	

}
