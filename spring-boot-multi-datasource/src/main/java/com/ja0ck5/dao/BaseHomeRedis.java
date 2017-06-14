package com.ja0ck5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.RedisProxy;

/**
 * Created by Jack on 2017/6/14.
 */
public class BaseHomeRedis {
    @Autowired
    RedisProxy homeRedis;
}
