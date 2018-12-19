package create.singleton;
//枚举方式 :枚举自由序列化，线程安全，天生保证单例
public enum Singleton05 {
	INSTANCE;
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Singleton05.INSTANCE);
		}
	}
}
