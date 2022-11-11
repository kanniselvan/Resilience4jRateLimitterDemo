package com.kanni.test;


import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestTemplate;

@Slf4j
public class RateLimiterTestCase {

    public static void main(String arg[]){


       RestTemplate restTemplate=new RestTemplate();

        for(int i=1;i<100;i++) {
            String output = restTemplate.getForObject("http://localhost:8080/home", String.class);
            log.info(output +" i ==  "+ i);
        }

    }
}
