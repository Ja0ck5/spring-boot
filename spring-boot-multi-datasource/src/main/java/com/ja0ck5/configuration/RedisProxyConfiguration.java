package com.ja0ck5.configuration;

import com.ja0ck5.model.RedisProxyFactoryBeans;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * Created by Jack on 2017/6/13.
 */
@Configuration
public class RedisProxyConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "fhvideo.redis")
    public RedisProxyFactoryBeans primaryRedisProxyFactoryBeans() throws Exception {
        return new RedisProxyFactoryBeans().build();
    }


}
