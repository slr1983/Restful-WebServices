package com.sumit.restfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.restfulwebservices.dao.UserDao;
import com.sumit.restfulwebservices.models.User;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userDao.getAllUsers();

	}

	@GetMapping("/users/{userid}")
	public User getUser(@PathVariable(name = "userid") String userId) {

		return userDao.getUserById(Integer.valueOf(userId));

	}

	@PostMapping("/users/add")
	public User addUser(@RequestBody User user) {

		return userDao.addUser(user);

	}

	@PostMapping("/users/update/{userid}")
	public User updateUser(@PathVariable(name = "userid") String userId, @RequestBody User user) {

		return userDao.updateUser(user, Integer.valueOf(userId));

	}

	@PostMapping("/users/delete/{userid}")
	public void deleteUser(@PathVariable(name = "userid") String userId) {

		userDao.deleteUserById(Integer.valueOf(userId));

	}

}
