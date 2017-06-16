package com.ja0ck5.controller;

import com.ja0ck5.model.RedisProxyFactoryBeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ja0ck5.dao.EffectiveRecordDao;
import com.ja0ck5.model.EffectiveRecord;
import redis.clients.jedis.RedisProxy;

/**
 * User service which uses primary data source.
 * 
 * @author Michael Liao
 */
@RestController
public class EffectiveController {

	@Autowired
	EffectiveRecordDao effectiveRecordDao;

	@Autowired
	private RedisProxy homeRedis;

	@Autowired
	@Qualifier("dataRedis")
	private RedisProxy dataRedis;

	@Autowired
	private RedisProxyFactoryBeans factoryBeans;

	@GetMapping("/api/effective/{id}")
	public EffectiveRecord getUser(@PathVariable("id") long id) {
		return effectiveRecordDao.getById(id);
	}

	@GetMapping("/api/redis/{id}")
	public String getCache(@PathVariable("id") long id) {

		try {
			String key = "test-ja0ck5";
			homeRedis.set(key, String.valueOf(id));
			dataRedis.set(key, "data" + String.valueOf(id));
			return factoryBeans.getName() + "#homredis#" + homeRedis.getServerName() + "#" + id + "#key="
					+ homeRedis.get(key) + "\r\n" + "#data-key=" + dataRedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
