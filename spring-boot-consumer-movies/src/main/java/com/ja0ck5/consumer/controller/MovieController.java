package com.ja0ck5.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ja0ck5.consumer.entity.User;

@RestController
public class MovieController {

    @Value("${user.userService.path}")
    String userServicePath;

    @Autowired
    @LoadBalanced // 使用 ribbon. 具有 ribbon 负载均衡
    RestTemplate restTemplate;


    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServicePath + id, User.class);
    }

    /**
     * use ribbon
     * @param id
     * @return
     */
    @GetMapping("/user/ribbon/{id}")
    public User useRibbon(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServicePath + id, User.class);
    }

}
