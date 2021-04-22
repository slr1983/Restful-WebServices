package com.sumit.restfulwebservices.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All details about an user")
public class User {

	@Size(min = 3, message = "Name should have at least 3 characters.")
	@ApiModelProperty(notes = "Name should have at least 3 characters.")
	private String name;
	private String hobbies;

	@Id
	@GeneratedValue
	private Integer id;
	@Past
	@ApiModelProperty(notes = "Birthdate should be in past.")
	private Date dateOfBirth;

	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<>();

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

	@Override
	public String toString() {
		return "User [name=" + name + ", hobbies=" + hobbies + ", id=" + id + ", dateOfBirth=" + dateOfBirth + "]";
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {

		this.posts.addAll(posts);

	}

}
