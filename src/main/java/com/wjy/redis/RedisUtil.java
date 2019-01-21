package com.wjy.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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

	public Object get(String key) {

		Object value = redisTemplate.opsForValue().get(key);

		return value;

	}

	public Long leftPush(String key, Object value) {

		Long l = redisTemplate.opsForList().leftPush(key, value);

		return l;

	}

	public Object leftPush(String key) {

		Object value = redisTemplate.opsForList().rightPop(key);

		return value;

	}

	public Object leftPush(String key, long timeout, TimeUnit unit) {

		Object value = redisTemplate.opsForList().rightPop(key, timeout, unit);

		return value;

	}

	public Boolean add(String key, Object member, double score) {

		Boolean b = redisTemplate.opsForZSet().add(key, member, score);

		return b;

	}

	public Double score(String key, Object member) {

		Double score = redisTemplate.opsForZSet().score(key, member);

		return score;

	}

	public Long remove(String key, Object member) {

		Long l = redisTemplate.opsForZSet().remove(key, member);

		return l;

	}

}
