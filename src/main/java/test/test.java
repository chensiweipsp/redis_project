package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class test {


	public static void main(String[] args) {

		RedisTemplate<String, Object> redisTemplate= (RedisTemplate<String, Object>) new ClassPathXmlApplicationContext("application.xml").getBean("redisTemplate");

		//写入缓存

		/*	  ValueOperations<String, Object> operations = redisTemplate.opsForValue();

	  operations.set("helloredis02", "this is my life");*/

		/*	  List<String> lists = new  ArrayList<String>();
	  lists.add("a");
	  lists.add("b");

	  ValueOperations<String, Object> operations= redisTemplate.opsForValue();
	  operations.set("list", lists);*/

		//设置失效时间
		//	  redisTemplate.expire("helloredis", 1000, TimeUnit.SECONDS);



		//读取缓存
		/*  
	  ValueOperations<String, Object> operations =  redisTemplate.opsForValue();

	  System.err.println(operations.get("list"));
		 */


		//清除缓存
		redisTemplate.delete("list");

	}

}
