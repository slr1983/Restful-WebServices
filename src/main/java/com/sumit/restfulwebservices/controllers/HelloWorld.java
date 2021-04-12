package com.sumit.restfulwebservices.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	private final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

	@GetMapping({ "/", "helloworld", "" })
	public String helloWorld() {

		LOGGER.info("In helloWorld()");

		return "Hello World";
	}
	
	@GetMapping("helloworldbean")
	public HelloWorldBean helloWorldBean() {

		LOGGER.info("In helloWorldBean()");

		return new HelloWorldBean("Inside HelloWorldBean");
	}

}
