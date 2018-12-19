package create.prototype.simple.client;

import create.prototype.Protype;

public class Client {
	
	private Protype protype;

	public Protype getProtype() {
		return protype.clone();
	}

	public void setProtype(Protype protype) {
		this.protype = protype;
	}
	
	

}
