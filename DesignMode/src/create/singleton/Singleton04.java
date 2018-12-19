package create.singleton;
//静态内部类方式
public class Singleton04 {
	
	private Singleton04(){}
	private static class Singleton{
		private static final Singleton04  instance = new Singleton04();
		
	}
	
	public static Singleton04 getInstance(){
		return Singleton.instance;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Singleton04.getInstance());
		}
	}

}
