package com.wjy.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void rightPopListTest() {
        try {
            while (true) {
                Object value = redisUtil.rightPopList("list");
                if (value == null) {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("暂无");
                } else {
                    System.out.println("value: " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void leftPushListTest() {
        try {
            for (int i = 1; i <= 10; i++) {
                redisUtil.leftPushList("list", i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
