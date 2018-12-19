package create.prototype.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import create.prototype.Person;

/**
 * 序列化实现深克隆(被引用的类也需要实现序列化接口)
 * @author Administrator
 *
 */
public class Protype5 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6220264097323143334L;
	private Person person;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public static Protype5 clone(Protype5 p){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream ous = null;
		ObjectInputStream ins = null;  
		
		try {
			ous = new ObjectOutputStream(out);
			ous.writeObject(p);
			ins = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
			return (Protype5)ins.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				ins.close();
				ous.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}


}
