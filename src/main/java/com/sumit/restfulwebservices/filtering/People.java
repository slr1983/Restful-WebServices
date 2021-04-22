package com.sumit.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value = {"name"})

@JsonFilter(value = "PeopleFilter")
public class People {	
	
	private String name;
	
	//@JsonIgnore
	private Integer age;
	private String occupation;
	private String address;
	
	
	private Integer phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", occupation=" + occupation + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	public People(String name, Integer age, String occupation, String address, Integer phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.occupation = occupation;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	People(){
		
	}
	

}
