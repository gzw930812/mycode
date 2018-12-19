package action.observer.subject;

import action.observer.observer.Observer;

public interface Subject {
	
	void addObserver(Observer o);
	
	void delObserver(Observer o);
	
	void notiy();

}
