package com.hitProject.hitDemo.Service;

public interface RedisHitCounterService {
    void increment();

    long getHits();
}
