package com.gzw.concurrent.delay;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class DelayDequeMain {
	 public static void main(String[] args) throws Exception {
		 
	        DelayQueue<DelayEvent> queue = new DelayQueue<DelayEvent>();
	        new Thread(() -> {
	        	queue.offer(new DelayEvent(new Date().getTime() + 2*1000));
	        	queue.offer(new DelayEvent(new Date().getTime() + 4*1000));
	        	queue.offer(new DelayEvent(new Date().getTime() + 6*1000));
	        	queue.offer(new DelayEvent(new Date().getTime() + 8*1000));
	        }).start();
	        
	        while (true) {
				DelayEvent event = queue.take();
				System.out.println(event.getStartDate());
			}
	    }

}
