package create.builder.builder;

import create.builder.entiy.Body;
import create.builder.entiy.Head;
import create.builder.entiy.Leg;
import create.builder.entiy.Person;

public abstract class PersonBuilder {
	

	abstract Head builderHead();
	abstract Body builderBody();
	abstract Leg builderLeg();
	public Person getPerson(){
		Person p = new Person();
		p.setBody(builderBody());
		p.setHead(builderHead());
		p.setLeg(builderLeg());
		return p;
	};
	
}
