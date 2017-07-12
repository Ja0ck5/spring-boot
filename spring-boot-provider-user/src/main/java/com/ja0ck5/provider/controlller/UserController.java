package com.ja0ck5.provider.controlller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ja0ck5.provider.dao.UserDao;
import com.ja0ck5.provider.entity.User;

@RestController
public class UserController {

	@Qualifier("eurekaClient")
	@Autowired
	EurekaClient eurekaClient;

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	UserDao userDao;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return userDao.findOne(id);
	}

	@GetMapping("/eureka/client/{id}")
	public String getEurekaClientInfo(@PathVariable Long id){
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("MICRO-USER", false);
		return instanceInfo.getHomePageUrl();
	}
}
