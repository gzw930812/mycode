package structure.adapter;

//日本电饭煲，标准电压110V
public class RiceCooker {

	private JP110V jp110V;
	public RiceCooker(JP110V jp110V) {
		this.jp110V = jp110V;
	}
	public void cook(){
		jp110V.connect();
		System.out.println("开始煮饭。。。");
	}
	public JP110V getJp110V() {
		return jp110V;
	}
	public void setJp110V(JP110V jp110v) {
		jp110V = jp110v;
	}
	
	
}
