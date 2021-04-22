package com.sumit.restfulwebservices.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	private String postmessage;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public String getPostmessage() {
		return postmessage;
	}

	public void setPostmessage(String postmessage) {
		this.postmessage = postmessage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Post [postmessage=" + postmessage + ", id=" + id + "]";
	}

	public Post(String postmessage, Integer id, User user) {

		this.postmessage = postmessage;
		this.id = id;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	Post() {

	}

}
