package com.ja0ck5.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import redis.clients.jedis.RedisProxy;
import redis.clients.jedis.RedisProxyFactoryBean;

import java.util.Properties;

/**
 * Created by Jack on 2017/6/13.
 */
@Configuration
public class RedisProxyConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisProxyFactoryBean primaryRedisProxyFactoryBean() throws Exception {
        return new RedisProxyFactoryBean();
    }


}
