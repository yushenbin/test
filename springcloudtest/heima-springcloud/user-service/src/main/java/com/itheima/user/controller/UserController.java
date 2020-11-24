package com.itheima.user.controller;

import com.itheima.user.pojo.User;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query/{id}")
    public User queryById(@PathVariable Long id){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.queryById(id);
    }
    @RequestMapping("/delete/{id}")
    public int deleteById(@PathVariable Long id){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.deleteById(id);
    }
    @PostMapping("/update")
    public int updateById(@RequestBody User user){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(user);
        return userService.updateById(user);
    }
    @PostMapping("/insert")
    public int insertById(@RequestBody User user){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(user);
        return userService.insertById(user);
    }
}
