package com.itheima.consumer.controller;

import com.itheima.consumer.client.UserClient;
import com.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;
    @RequestMapping("/query/{id}")
    public User queryById(@PathVariable Long id){
        return userClient.queryById(id);
    }
    @RequestMapping("/delete/{id}")
    public User deleteById(@PathVariable Long id){
        return userClient.deleteById(id);
    }
    @RequestMapping(value = "/update")
    public User updateById(User user){
        System.out.println(user);
        return userClient.updateById(user);
    }
    @RequestMapping(value = "/insert")
    public User insertById(User user){
        System.out.println(user);
        return userClient.insertById(user);
    }
}
