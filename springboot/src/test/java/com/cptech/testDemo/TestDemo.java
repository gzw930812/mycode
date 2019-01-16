package com.cptech.testDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import com.cptech.common.redis.shiro.RedisCache;
import com.cptech.common.redis.shiro.RedisManager;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
	@Autowired
	RedisManager redisManager;
	
	@Test
	public void testRedis() {
		RedisCache<String, Object> redisCache=new RedisCache<>(redisManager);
		redisCache.put("test", "hello");
		
		Object object = redisCache.get("test");
		System.out.println(object.toString());
	}
}
