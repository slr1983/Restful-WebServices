package com.sumit.restfulwebservices.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	private final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
	
	@Autowired
	private MessageSource messageSource; 

	@GetMapping("helloworld")
	public String helloWorld() {

		LOGGER.info("In helloWorld()");

		return "Hello World";
	}
	
	@GetMapping("helloworldbean")
	public HelloWorldBean helloWorldBean() {

		LOGGER.info("In helloWorldBean()");

		return new HelloWorldBean("Inside HelloWorldBean");
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}
