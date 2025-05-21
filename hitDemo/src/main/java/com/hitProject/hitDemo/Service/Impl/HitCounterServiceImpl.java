package com.hitProject.hitDemo.Service.Impl;

import com.hitProject.hitDemo.Service.HitCounterService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class HitCounterServiceImpl implements HitCounterService {

    private final AtomicLong hitCount = new AtomicLong(0);

    @Override
    public void increment() {
            hitCount.incrementAndGet();
    }

    @Override
    public long getHits() {
        return hitCount.get();
    }
}
