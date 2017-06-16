package com.ja0ck5.configuration;

import com.ja0ck5.model.RedisProxyFactoryBeans;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import redis.clients.jedis.RedisProxy;

/**
 * Created by Jack on 2017/6/13.
 */
@Configuration
public class RedisProxyConfiguration {

//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "fhvideo.redis.home")
//	public RedisProxyFactoryBeans primaryRedisProxyFactoryBeans() throws Exception {
//		return new RedisProxyFactoryBeans();
//	}
//
//	@Bean
//	@Primary
//	public RedisProxy homeRedis(RedisProxyFactoryBeans redisProxyFactoryBeans) throws Exception {
//		return redisProxyFactoryBeans.build();
//	}
//
//	@Bean(name = "dataRedisProxyFactoryBeans")
//	@ConfigurationProperties(prefix = "fhvideo.redis.data")
//	public RedisProxyFactoryBeans dataRedisProxyFactoryBeans() throws Exception {
//		return new RedisProxyFactoryBeans();
//	}
//
//	@Bean(name = "dataRedis")
//	public RedisProxy dataRedis(@Qualifier("dataRedisProxyFactoryBeans") RedisProxyFactoryBeans dataRedisProxyFactoryBeans) throws Exception {
//		return dataRedisProxyFactoryBeans.build();
//	}


	@Bean(initMethod = "build",destroyMethod = "destroy")
	@Primary
	@ConfigurationProperties(prefix = "fhvideo.redis.home")
	public RedisProxyFactoryBeans primaryRedisProxyFactoryBeans() throws Exception {
		return new RedisProxyFactoryBeans();
	}

	@Bean
	@Primary
	public RedisProxy homeRedis(RedisProxyFactoryBeans redisProxyFactoryBeans) throws Exception {
		return redisProxyFactoryBeans.getObject();
	}

	@Bean(name = "dataRedisProxyFactoryBeans",initMethod = "build", destroyMethod = "destroy")
	@ConfigurationProperties(prefix = "fhvideo.redis.data")
	public RedisProxyFactoryBeans dataRedisProxyFactoryBeans() throws Exception {
		return new RedisProxyFactoryBeans();
	}

	@Bean(name = "dataRedis")
	public RedisProxy dataRedis(@Qualifier("dataRedisProxyFactoryBeans") RedisProxyFactoryBeans dataRedisProxyFactoryBeans) throws Exception {
		return dataRedisProxyFactoryBeans.getObject();
	}

}
