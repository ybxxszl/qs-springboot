package com.wjy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wjy.redis.RedisUtil;
import com.wjy.util.RandomCodeUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QSApplicationTests {

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void contextLoads() {

	}

	@Test
	public void redisTest() {

		redisUtil.set("UUID", RandomCodeUtil.getUUID());

	}

}
