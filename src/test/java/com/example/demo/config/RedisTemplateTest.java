package com.example.demo.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTemplateTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void opsForValue() {
        final String key = "sabarada";
        final ValueOperations<String, String> vos = redisTemplate.opsForValue();

        vos.set(key, "1"); // redis set 명령어
        final String result_1 = vos.get(key); // redis get 명령어
        System.out.println("result_1 = " + result_1);
        assertEquals("1", result_1);

        vos.increment(key); // redis incr 명령어
        final String result_2 = vos.get(key);
        System.out.println("result_2 = " + result_2);
        assertEquals("2", result_2);
    }

    @Test
    void addBlackList() {
        final String keyPrefix = "blacklist:";
        final String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtb2lqIiwiaWF0IjoxNjA1NTg5NTk1LCJleHAiOjE2MDU1OTMxOTUsInVzZXIiOiIyMjI1MTEiLCJ1c2VyVHlwZSI6MH0.JXjg2PDDZovKonkZqjdCjqLNZwpEvmsdeOh6WBLFV9A";
        final ValueOperations<String, String> vos = redisTemplate.opsForValue();
        final int loopCount = 100;

        for (int i = 0; i < loopCount; i++) {
            String key = keyPrefix + System.currentTimeMillis() + ":" + token;
            vos.set(key, "1");
            final String result_1 = vos.get(key);
            redisTemplate.expire(key, 1, TimeUnit.HOURS); // 1시간
            System.out.println("result_1 = " + result_1);
            assertEquals("1", result_1);
        }
    }

}
