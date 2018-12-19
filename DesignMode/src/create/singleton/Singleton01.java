package create.singleton;

//饿汉式   天生线程安全
public class Singleton01 {
	
	private static final Singleton01 s = new Singleton01();
	private Singleton01(){
	}
	
	public static Singleton01 getIntance(){
		return s;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
			new Thread(() -> {
				System.out.println(Singleton01.getIntance());
			}).start();
		}
	}
	

}
