package com.cptech.testDemo;

import com.whalin.MemCached.MemCachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
 
	@Autowired
	MemCachedClient memCachedClient;
 
	@Test
	public void contextLoads() {
		boolean i = memCachedClient.set("id", 123, 1000);
		System.out.println(String.valueOf(i));
		System.out.println(memCachedClient.get("id"));
	}
 
}
