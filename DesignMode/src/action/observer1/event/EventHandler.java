package action.observer1.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventHandler {
	
	public void invoke(Event event){
		
		try {
			Method method = event.getTarget().getClass().getMethod(event.getMethodName(), event.getParamTypes());
			method.invoke(event.getTarget(), event.getParams());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
