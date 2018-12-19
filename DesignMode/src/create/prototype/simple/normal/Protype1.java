package create.prototype.simple.normal;

import create.prototype.Protype;

public class Protype1 implements Protype{

	private String name;
	
	public Protype clone(){
		
		Protype protype = new Protype1();
		protype.setName(this.name);
		return protype;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	
}
