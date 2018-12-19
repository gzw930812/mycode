package action.observer;

import java.util.ArrayList;

import action.observer.observer.Observer;
import action.observer.observer.Observer1;
import action.observer.subject.Subject;
import action.observer.subject.Subject1;

public class Test {
	
	public static void main(String[] args) {
		
		Subject subject = new Subject1(new ArrayList<Observer>());
		for (int i = 0; i < 3; i++) {
			Observer o = new Observer1("观察者"+(i+1));
			subject.addObserver(o);
		}
		subject.notiy();
	}

}
