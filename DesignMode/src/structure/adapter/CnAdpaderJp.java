package structure.adapter;

//适配器，使得日本电饭煲可以接通中国标准电压
public class CnAdpaderJp implements JP110V {
	
	private CN220V cn220V;
	
	public CnAdpaderJp(CN220V cn220V) {
		this.cn220V = cn220V;
	}

	@Override
	public void connect() {
		cn220V.connect();
		System.out.println("转化为110V电压。。。");
	}
	
	

}
