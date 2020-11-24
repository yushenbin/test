package com.itheima.consumer.client;

import com.itheima.consumer.client.fallback.UserClientFallback;
import com.itheima.consumer.config.FeignConfig;
import com.itheima.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user-service",fallback = UserClientFallback.class,
configuration = FeignConfig.class)
public interface UserClient {
    @RequestMapping("/user/query/{id}")
    User queryById(@PathVariable("id")Long id);
    @RequestMapping("/user/delete/{id}")
    User deleteById(@PathVariable("id")Long id);
    @PostMapping("/user/update")
    User updateById(@RequestBody User user);
    @PostMapping("/user/insert")
    User insertById(@RequestBody User user);
}
