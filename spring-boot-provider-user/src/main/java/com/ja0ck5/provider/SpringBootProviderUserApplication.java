package com.ja0ck5.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProviderUserApplication.class, args);
	}
}
