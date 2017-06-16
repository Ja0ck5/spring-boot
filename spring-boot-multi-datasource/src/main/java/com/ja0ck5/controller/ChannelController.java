package com.ja0ck5.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ja0ck5.dao.ChannelDao;
import com.ja0ck5.model.Channel;

import javax.sql.DataSource;

@RestController
public class ChannelController {

	@Autowired
	ChannelDao channelDao;

	@GetMapping("/api/all")
	public List<Channel> getAll() {
		List<Channel> all = channelDao.getAll();
		return all;
	}

	@GetMapping("/api/channel/{id}")
	public Channel getBook(@PathVariable("id") long id) {
		Channel channel = channelDao.getById(id);
		return channel;
	}

	@GetMapping("/api/info/{id}")
	public String getInfo(@PathVariable("id")long id) throws SQLException {
		DataSource dataSource = channelDao.getJdbcTemplate().getDataSource();
		return dataSource.getClass().getName() + "#" +dataSource.getLoginTimeout()+ id;
	}

}
