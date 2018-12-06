package com.gzw.thread;

/**
 * 结论：守护线程会守护所有非守护线程，当所有子线程和主线程终止后，守护线程才终止
 * @author gzw
 *
 */
public class Test01 {
	public static void main(String[] args) {
		
		Thread main = Thread.currentThread();
		//守护线程
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("守护线程t1:"+i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}) ;
		System.out.println(t1.getState());
		t1.setDaemon(true);
		t1.start();
		//子线程
		/*Thread t2 = new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				System.out.println("子线程t2:"+i);
				if(i==1){
					System.out.println(main.getState());
				}
				if(i==10){
					System.out.println(main.getState());
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		});
		t2.start();*/
		/*for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("主线程main:"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
}


