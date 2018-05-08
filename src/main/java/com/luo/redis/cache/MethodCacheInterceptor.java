package com.luo.redis.cache;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class MethodCacheInterceptor implements MethodInterceptor {
	
	private RedisTemplate<Serializable, Object> redisTemplate;
	
	private Long defaultCacheExpireTime = 10l; // ����Ĭ�ϵĹ���ʱ��,����������10��
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		return null;
	}
	/**
	 * ��������key
	 *
	 * @param targetName
	 * @param methodName
	 * @param arguments
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer sbu = new StringBuffer();
		sbu.append(targetName).append("_").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sbu.append("_").append(arguments[i]);
			}
		}
		return sbu.toString();
	}
	
	
	/**
	 * �жϻ������Ƿ��ж�Ӧ��value
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}
	/**
	 * ��ȡ����
	 * 
	 * @param key
	 * @return
	 */
	public Object getCache(final String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate
				.opsForValue();
		result = operations.get(key);
		return result;
	}
	/**
	 * д�뻺��
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setCache(final String key, Object value, Long expireTime) {
		boolean result = false;
		
		try {
			
			ValueOperations<Serializable, Object> operations = redisTemplate
					.opsForValue();
			
			operations.set(key, value);
			
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			
			
			result = true;
		
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
	}
	
	
	public void setRedisTemplate(
			RedisTemplate<Serializable, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}