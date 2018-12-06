package com.gzw.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import com.gzw.po.Person;

public class TestAnsyc {
	
	public static void main(String[] args) {
		 // 两个线程的线程池  
        ExecutorService executor = Executors.newFixedThreadPool(2);  
        //jdk1.8之前的实现方式  
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {  
            @Override  
            public String get() {  
                System.out.println("task started!");  
                try {  
                    //模拟耗时操作  
                    Thread.sleep(2000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                return "task finished!";  
            }  
        }, executor);  
  
        //采用lambada的实现方式  
        future.thenAccept(e -> System.out.println(e));  
        
        
        System.out.println("main thread is running");  
        Test1 add = (a,b) -> a+b;
        Test1 sub = (a,b) -> a-b;
        Test2 t = (s) -> System.out.println(s);
        t.aa("mmmmmmm");
        System.out.println(add.operation(3, 4));
       
        System.out.println(ex(1,2,add));
        System.out.println(ex(4,2,sub));
        re(e -> {String m = e+"kkk"; System.out.println(m);});
        
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.forEach((li) -> System.out.println(li));
        new Thread(() -> System.out.println("sss")).start(); 
        new Person(() -> System.out.println("ggg")).ex();
	}
	
	interface Test1{
		int operation(int a,int b);
	}
	interface Test2{
		void aa(String a);
	}
	
	public static void re(Test2 t){
		t.aa("pppppp");
	}
	
	private static int ex(int a,int b,Test1 test){
		return test.operation(a, b);
	}
	
	

}
