package action.observer.observer;

public class Observer1 implements Observer{
	
	private String name;
	
	public Observer1(String name) {
		this.name = name;
	}
	
	@Override
	public void update() {
		
		System.out.println(name+"做出更新");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
