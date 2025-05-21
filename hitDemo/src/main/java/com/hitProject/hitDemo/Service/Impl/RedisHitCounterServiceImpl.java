package com.hitProject.hitDemo.Service.Impl;

import com.hitProject.hitDemo.Service.RedisHitCounterService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisHitCounterServiceImpl implements RedisHitCounterService {

    private static final String HIT_KEY = "site:hits";

    private final StringRedisTemplate redisTemplate;

    public RedisHitCounterServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void increment() {
        redisTemplate.opsForValue().increment(HIT_KEY);
    }

    @Override
    public long getHits() {
        String val = redisTemplate.opsForValue().get(HIT_KEY);
        return val != null ? Long.parseLong(val) : 0;
    }


}
