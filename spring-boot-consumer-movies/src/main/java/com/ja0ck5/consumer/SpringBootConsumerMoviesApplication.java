package com.ja0ck5.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
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
