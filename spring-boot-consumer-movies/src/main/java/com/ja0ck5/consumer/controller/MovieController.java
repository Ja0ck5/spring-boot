package com.ja0ck5.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ja0ck5.consumer.entity.User;

@RestController
public class MovieController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://localhost:8080/simple/" + id, User.class);
	}

}
