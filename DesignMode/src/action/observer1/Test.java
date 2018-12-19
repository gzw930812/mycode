package action.observer1;

import java.util.ArrayList;

import action.observer1.event.Event;
import action.observer1.event.EventHandler;
import action.observer1.observer.Bird;
import action.observer1.observer.Person;
import action.observer1.subject.Subject;

public class Test {
	
	
	public static void main(String[] args) {
		Subject subject = new Subject(new ArrayList<Event>(), new EventHandler());
		
		Bird bird = new Bird();
		Person person = new Person();
		subject.addObserver("fly", bird, null);
		subject.addObserver("addCloths", person, null);
		subject.notiy();
	}

}
