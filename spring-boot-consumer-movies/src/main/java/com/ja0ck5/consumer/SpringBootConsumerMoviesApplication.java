package com.ja0ck5.consumer;

import com.ja0ck5.config.TestConfiguration;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="micro-service-provider-user",configuration = TestConfiguration.class)// TestConfiguration 不能放在可被扫描到的包下
public class SpringBootConsumerMoviesApplication {

	/**
	 * 用@LoadBalanced限定符来访问负载平衡RestTemplate
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate loadBalanced() {
		return new RestTemplate();
	}

	/**
	 * 没有负载平衡的RestTemplate
	 * @Primary 注释，以消除不合格的@Autowired注入
	 * @return
	 */
	@Primary
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsumerMoviesApplication.class, args);
	}
}
