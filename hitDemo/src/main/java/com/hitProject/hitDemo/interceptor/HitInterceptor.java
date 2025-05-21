package com.hitProject.hitDemo.interceptor;


import com.hitProject.hitDemo.Service.HitCounterService;
import com.hitProject.hitDemo.Service.RedisHitCounterService;
import com.hitProject.hitDemo.Service.UserHitService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HitInterceptor implements HandlerInterceptor{
    private final HitCounterService hitcounterService;
    private final UserHitService userHitService;
    private final RedisHitCounterService redisHitCounterService;

    @Autowired
    public HitInterceptor(HitCounterService hitcounterService , UserHitService userHitService ,RedisHitCounterService redisHitCounterService) {
        this.hitcounterService = hitcounterService;
        this.userHitService =userHitService;
        this.redisHitCounterService = redisHitCounterService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        you can use any one of following service
        hitcounterService.increment();
        userHitService.incrementHit();
        redisHitCounterService.increment();
        return true; //-->Continue processing the request
    }
}
