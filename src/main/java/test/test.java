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

		//д�뻺��

		/*	  ValueOperations<String, Object> operations = redisTemplate.opsForValue();

	  operations.set("helloredis02", "this is my life");*/

		/*	  List<String> lists = new  ArrayList<String>();
	  lists.add("a");
	  lists.add("b");

	  ValueOperations<String, Object> operations= redisTemplate.opsForValue();
	  operations.set("list", lists);*/

		//����ʧЧʱ��
		//	  redisTemplate.expire("helloredis", 1000, TimeUnit.SECONDS);



		//��ȡ����
		/*  
	  ValueOperations<String, Object> operations =  redisTemplate.opsForValue();

	  System.err.println(operations.get("list"));
		 */


		//�������
		redisTemplate.delete("list");

	}

}
