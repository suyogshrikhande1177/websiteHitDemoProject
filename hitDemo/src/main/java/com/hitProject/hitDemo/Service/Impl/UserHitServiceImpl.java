package com.hitProject.hitDemo.Service.Impl;

import com.hitProject.hitDemo.Service.UserHitService;
import com.hitProject.hitDemo.models.UserHits;
import com.hitProject.hitDemo.repository.UserHitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserHitServiceImpl implements UserHitService {
    @Autowired
    private UserHitsRepository userHitsRepository;

    private final Object lock = new Object();

    @Override
    @Transactional
    public void incrementHit() {
        synchronized (lock) {
            Optional<UserHits>hits = userHitsRepository.findById(1);
            if (!hits.isPresent()) {
                userHitsRepository.insertFirstHit();
            }else {
                UserHits hit =hits.get();
                hit.setHitCount(hit.getHitCount() + 1);
                userHitsRepository.save(hit);
            }

        }

    }

    @Override
    public long getHits() {
        UserHits hit = userHitsRepository.findById(1) .orElseThrow();
        return hit.getHitCount();
    }
}
