/**
 * 
 */
package com.sumit.restfulwebservices.controllers;

/**
 * @author sumit
 *
 */
public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		
		return "HelloWorldBean [message=" + message + "]";

		// return Arrays.asList("Hello", "My World", "How are you").toString();
	}

}
