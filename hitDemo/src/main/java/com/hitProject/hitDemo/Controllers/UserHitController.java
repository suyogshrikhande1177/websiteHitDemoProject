package com.hitProject.hitDemo.Controllers;

import com.hitProject.hitDemo.Service.HitCounterService;
import com.hitProject.hitDemo.Service.RedisHitCounterService;
import com.hitProject.hitDemo.Service.UserHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userHit")
public class UserHitController {


    private UserHitService userHitService;

    private HitCounterService counterService;

    private RedisHitCounterService redisHitCounterService;

    @Autowired
    public UserHitController(UserHitService userHitService, HitCounterService counterService,RedisHitCounterService redisHitCounterService) {
        this.userHitService = userHitService;
        this.counterService = counterService;
        this.redisHitCounterService = redisHitCounterService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to the demo hit site!",HttpStatus.OK);
    }

    @GetMapping("/v1/get") //This is not a good way of Practice.
    ResponseEntity<Long> getUserHits(){
            userHitService.incrementHit();//--> We Can Use this line every method
            return new ResponseEntity<>(userHitService.getHits(), HttpStatus.OK);
    }

    @GetMapping("/v2/get") //Using Application Event
    ResponseEntity<Long> getUserHitsCount1(){
        return new ResponseEntity<>(counterService.getHits(), HttpStatus.OK);
    }

    @GetMapping("/v3/get") // Using Database
    ResponseEntity<Long> getUserHitsCount2(){
            return new ResponseEntity<>(userHitService.getHits(), HttpStatus.OK);
    }

    @GetMapping("/v4/get") //using redisTemplate
    ResponseEntity<Long> getUserHitsCount3(){
        return new ResponseEntity<>(redisHitCounterService.getHits(), HttpStatus.OK);
    }

}
