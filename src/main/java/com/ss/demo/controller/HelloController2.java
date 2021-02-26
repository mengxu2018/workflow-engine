package com.ss.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhang
 */
@RestController
public class HelloController2 {

	@RequestMapping("/hello")
	public String index() {
		return "hello Spring Boot!";
	}

}