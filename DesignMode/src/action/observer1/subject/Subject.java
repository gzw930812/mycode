package action.observer1.subject;

import java.util.List;

import action.observer1.event.Event;
import action.observer1.event.EventHandler;

public class Subject {
	
	private List<Event> observers;
	private EventHandler handler;
	
	
	
	public Subject(List<Event> observers, EventHandler handler) {
		super();
		this.observers = observers;
		this.handler = handler;
	}
	
	

	public Subject() {
		super();
	}

	public void notiy(){
		if(null == observers || observers.isEmpty()){
			return;
		}
		
		if(null == handler){handler = new EventHandler();}
		System.out.println("天气变冷了。。。");
		for (Event event : observers) {
			handler.invoke(event);
		}
	};
	
	public void addObserver(String methodName,Object target,Object[] params){
		observers.add(new Event(methodName, target, params));
	};
	
	public void delObserver(String methodName,Object target,Object[] params){
		observers.remove(new Event(methodName, target, params));
	}

	public List<Event> getObservers() {
		return observers;
	}

	public void setObservers(List<Event> observers) {
		this.observers = observers;
	}

	public EventHandler getHandler() {
		return handler;
	}

	public void setHandler(EventHandler handler) {
		this.handler = handler;
	};
	
	

}
