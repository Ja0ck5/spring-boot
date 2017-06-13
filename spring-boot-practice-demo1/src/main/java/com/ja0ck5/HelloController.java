package com.ja0ck5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ja0ck5 on 2017/6/2.
 */
@RestController
public class HelloController {

	// @Value("${cupSize}")
	// private String cupSize;
	//
	// @Value("${age}")
	// private int age;
	//
	// @Value("${content}")
	// private String content;

	@Autowired
	private GirlProperties girlProperties;
	@Autowired
	private BoyProperties boyProperties;

	@GetMapping("/girl")
	public String girl() {
		return girlProperties.getCupSize();
	}

	@GetMapping("/boy")
	public String boy() {
		return boyProperties.getCupSize();
	}
}
