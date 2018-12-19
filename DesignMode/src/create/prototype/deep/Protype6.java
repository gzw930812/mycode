package create.prototype.deep;

/**
 * 引用类型和本类都重修clone方法
 * @author Administrator
 *
 */
public class Protype6 implements Cloneable{

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Protype6 clone() throws CloneNotSupportedException{
		Protype6 p = (Protype6) super.clone();
		p.person = person.clone();
		return p;
	}
	
}
