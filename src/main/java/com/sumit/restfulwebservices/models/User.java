package com.sumit.restfulwebservices.models;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;
	private String hobbies;
	private Integer id;
	private Date dateOfBirth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public User(String name, String hobbies, Integer id, Date dateOfBirth) {
		this.name = name;
		this.hobbies = hobbies;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
	}

	
	public User() {
		
	}

}
