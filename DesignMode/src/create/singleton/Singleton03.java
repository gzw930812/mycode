package create.singleton;

//双重检验锁
public class Singleton03 {

	private static volatile Singleton03 s;
	private Singleton03(){}
	public static Singleton03 getInstance(){
		if(null == s){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (Singleton03.class) {
				if(null == s){
					s = new Singleton03(); //可能出现重排序，多线程不安全
				}
			}
		}
		return s;
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			
			new Thread(() -> {
				System.out.println(Singleton03.getInstance());
			}).start();
		}
	}
}
