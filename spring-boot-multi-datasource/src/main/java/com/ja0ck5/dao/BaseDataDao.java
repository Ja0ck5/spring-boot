package com.ja0ck5.dao;

import com.ja0ck5.model.RedisProxyFactoryBeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.RedisProxy;

public class BaseDataDao {
	@Autowired
	@Qualifier("dataJdbcTemplate")
	private JdbcTemplate dataJdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return dataJdbcTemplate;
	}

}