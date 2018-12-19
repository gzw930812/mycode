package action.observer1.event;

public class Event {
	
	private String methodName;
	private Object target;
	private Object[] params;
	private Class[] paramTypes;
	
	public Event(String methodName,Object target,Object[] params) {
		this.methodName = methodName;
		this.params = params;
		this.target = target;
		if(null != params){
			this.paramTypes = getParamTypes();
		}
	}
	
	private Class[] getParamTypes(Object[] params){
		Class[] paramTypes = new Class[params.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = params[i].getClass();
		}
		return paramTypes;
	}

	public Class[] getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
	

}
