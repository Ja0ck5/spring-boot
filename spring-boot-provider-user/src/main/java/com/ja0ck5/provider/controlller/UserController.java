package com.ja0ck5.provider.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ja0ck5.provider.dao.UserDao;
import com.ja0ck5.provider.entity.User;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return userDao.findOne(id);
	}
}
