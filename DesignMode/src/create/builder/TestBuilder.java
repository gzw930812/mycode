package create.builder;

import create.builder.builder.FatPersonBuilder;
import create.builder.builder.PersonBuilder;
import create.builder.entiy.Person;


public class TestBuilder {
	
	public static void main(String[] args) {
		
		PersonBuilder builder = new FatPersonBuilder();
		Person p = builder.getPerson();
		System.out.println(p.getHead().getDes());
		System.out.println(p.getBody().getDes());
		System.out.println(p.getLeg().getDes());
	}

}
