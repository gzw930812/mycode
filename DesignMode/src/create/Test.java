package create;

import create.prototype.Person;
import create.prototype.deep.Protype3;
import create.prototype.deep.Protype5;
import create.prototype.deep.Protype6;
import create.prototype.simple.clone.Protype2;

public class Test {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		/*Car car = CarFactoryAbstract.getCar(CarConstant.BMW);
		System.out.println(car.toString());*/
		
		/*Client client = new Client();
		Protype p1 = new Protype1();
		p1.setName("张三");
		client.setProtype(p1);
		System.out.println(client.getProtype() == p1);
		System.out.println(client.getProtype().getName() == p1.getName());*/
		
		Protype2 p2 = new Protype2();
		Person person = new Person();
		person.setName("李四");
		person.setAge(20);
		p2.setPerson(person);
		Protype2 p3 = p2.clone();
		System.out.println(p3 == p2);
		/**
		 * 说明对对象的引用没有改变  
		 */
		System.out.println( p3.getPerson() == p2.getPerson());
		
		Protype3 p4 = new Protype3();
		p4.setPerson(person);
		Protype3 p5 = p4.clone();
		System.out.println(p5 == p4);
		System.out.println(p5.getPerson() == p4.getPerson());
		
		Protype6 p6 = new Protype6();
		create.prototype.deep.Person person2 = new create.prototype.deep.Person();
		person2.setName("张飞");
		person2.setAge(30);
		p6.setPerson(person2);
		Protype6 p7 = p6.clone();
		p7.getPerson().setName("王八");
		System.out.println(p6.getPerson().getName());
		System.out.println(p7.getPerson().getName());
		
		Protype5 p8 = new Protype5();
		p8.setPerson(person);
		Protype5 p9 = Protype5.clone(p8);
		p9.getPerson().setName("lalala");
		System.out.println(p8.getPerson().getName());
		System.out.println(p9.getPerson().getName());
		
	}

}
