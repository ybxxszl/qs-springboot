package com.wjy.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public final class RedisUtil {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void set(String key, Object value) {

		redisTemplate.opsForValue().set(key, value);

	}
	
	public void set(String key, Object value, long timeout, TimeUnit unit) {

		redisTemplate.opsForValue().set(key, value, timeout, unit);

	}

}
