package structure.facede;

public class Facede {
	
	
	private MoudleA a;
	private MoudleB b;
	private MoudleC c;
	
	public void test(){
		a = new MoudleA();
		b = new MoudleB();
		c = new MoudleC();
		a.test1();
		b.test1();
		c.test1();
	}

	public MoudleA getA() {
		return a;
	}

	public void setA(MoudleA a) {
		this.a = a;
	}

	public MoudleB getB() {
		return b;
	}

	public void setB(MoudleB b) {
		this.b = b;
	}

	public MoudleC getC() {
		return c;
	}

	public void setC(MoudleC c) {
		this.c = c;
	}

}
