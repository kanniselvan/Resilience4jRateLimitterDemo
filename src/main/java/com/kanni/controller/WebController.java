package com.kanni.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/home")
public class WebController {

    @RateLimiter(name="processService", fallbackMethod = "processFallback")
    @GetMapping
    public String  welcomeString(){
        try {
            Thread.sleep(TimeUnit.SECONDS.toSeconds(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString()+"   "+ LocalDateTime.now();
    }

    public String processFallback(Throwable throwable){
        return  LocalDateTime.now()+ "=== "+throwable.getMessage();
    }
}
