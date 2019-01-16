package structure.adapter;

public class TestAdapter {

	
	public static void main(String[] args) {
		//现在用在日本用日本电饭煲煮饭
		RiceCooker rc = new RiceCooker(new JP110VImpl());
		rc.cook();
		
		//在中国用日本电饭煲煮饭。。。
		//由于接口不对，连接不了,下面这段代码报错
		//RiceCooker rc1 = new RiceCooker(new CN220VImpl());
		//改用适配器
		RiceCooker rc2 = new RiceCooker(new CnAdpaderJp(new CN220VImpl()));
		rc2.cook();
	}
}
