package action.observer.subject;

import java.util.List;

import action.observer.observer.Observer;

public class Subject1 implements Subject{
	
	List<Observer> list;
	
	public  Subject1(List<Observer> list) {
		this.list = list;
	}

	@Override
	public void notiy() {
		if(list.isEmpty()){
			return;
		}
		System.out.println("做出通知。。。");
		for (Observer observer : list) {
			observer.update();
		}
		
	}

	@Override
	public void addObserver(Observer o) {
		list.add(o);
	}

	@Override
	public void delObserver(Observer o) {
		list.remove(o);
	}	
}
