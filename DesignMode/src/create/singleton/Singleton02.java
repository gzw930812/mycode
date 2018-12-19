package create.singleton;

//懒汉式 天生线程不安全，加锁，保证线程安全，效率低
public class Singleton02 {

	private static Singleton02 s;
	private Singleton02 (){}
	public static Singleton02 getInstance(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (Singleton02.class) {
			if(s == null){
				s = new Singleton02();
			}
			return s;
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
			new Thread(() -> {
				System.out.println(Singleton02.getInstance());
			}).start();
		}
	}
	
}
