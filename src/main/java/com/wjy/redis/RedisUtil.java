package com.wjy.redis;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Redis工具类
 * 
 * @author wjy
 * @date 2019年1月22日
 */
@Component
public final class RedisUtil {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/*
	 * common
	 */

	/**
	 * 根据key判断缓存是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		try {
			Boolean b = redisTemplate.hasKey(key);
			return b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据keys删除缓存
	 * 
	 * @param keys
	 * @return
	 */
	public long delete(String... keys) {
		try {
			if (keys.length > 1) {
				Long l = redisTemplate.delete(Arrays.asList(keys));
				return l;
			} else if (keys.length == 1) {
				Boolean b = redisTemplate.delete(keys[0]);
				if (b) {
					return 1;
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 设置缓存失效时间
	 * 
	 * @param key
	 * @param timeout
	 * @return
	 */
	public boolean expire(String key, long timeout) {
		try {
			if (timeout > 0) {
				Boolean b = redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
				return b;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据key获取缓存失效时间
	 * 
	 * @param key
	 * @return
	 */
	public long getExpire(String key) {
		try {
			Long l = redisTemplate.getExpire(key, TimeUnit.SECONDS);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * string
	 */

	/**
	 * 放入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setValue(String key, Object value) {
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 放入缓存并且设置失效时间
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 * @return
	 */
	public boolean setValue(String key, Object value, long timeout) {
		try {
			if (timeout > 0) {
				redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据key获取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object getValue(String key) {
		try {
			Object value = redisTemplate.opsForValue().get(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据key增加或减少缓存的值
	 * 
	 * @param key
	 * @param delta
	 * @return
	 */
	public long changeValue(String key, long delta) {
		try {
			Long l;
			if (delta > 0) {
				l = redisTemplate.opsForValue().increment(key, delta);
			} else if (delta < 0) {
				l = redisTemplate.opsForValue().decrement(key, delta);
			} else {
				l = (Long) redisTemplate.opsForValue().get(key);
			}
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * list
	 */

	/**
	 * 推送缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public long leftPushList(String key, Object value) {
		try {
			Long l = redisTemplate.opsForList().leftPush(key, value);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 弹出缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object rightPopList(String key) {
		try {
			Object value = redisTemplate.opsForList().rightPop(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加缓存
	 * 
	 * @param key
	 * @param member
	 * @param score
	 * @return
	 */
	public boolean addZSet(String key, Object member, double score) {
		try {
			Boolean b = redisTemplate.opsForZSet().add(key, member, score);
			return b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据key和member获取分数
	 * 
	 * @param key
	 * @param member
	 * @return
	 */
	public double scoreZSet(String key, Object member) {
		try {
			Double score = redisTemplate.opsForZSet().score(key, member);
			return score;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 根据key和member移除缓存
	 * 
	 * @param key
	 * @param member
	 * @return
	 */
	public long removeZSet(String key, Object member) {
		try {
			Long l = redisTemplate.opsForZSet().remove(key, member);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
