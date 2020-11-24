package com.itheima.consumer.controller;

import com.itheima.consumer.pojo.User;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String queryById(@PathVariable Long id){

        String url="http://user-service/user/"+id;
        if(id==1){throw new RuntimeException("太忙了");}
        return restTemplate.getForObject(url, String.class);
    }
    public  String queryByIdFallback(Long id){
        log.error("id:{} fail",id);
        return "sorry";
    }
}
