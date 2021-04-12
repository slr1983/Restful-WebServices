package com.sumit.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sumit.restfulwebservices.models.User;

@Component
public class UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

	private static List<User> users = new ArrayList<User>(Arrays.asList(
			new User("SLR", "Reading, Coding", 1, new Date()), new User("Amit", "Dancing", 2, new Date()),
			new User("Prashant", "Reading, Swimming", 3, new Date()), new User("Kiran", "Fooling", 4, new Date())));

	public List<User> getAllUsers() {

		LOGGER.debug("Getting All User List.");

		return users;
	}

	public User getUserById(Integer userId) {

		for (User user : users) {

			if (user.getId().equals(userId)) {

				LOGGER.debug("Got User : " + user.getName());

				return user;
			}

		}

		return null;

	}

	public void deleteUserById(Integer userId) {

		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if (user.getId().equals(userId)) {
				iterator.remove();
				LOGGER.debug("Successfully deleted User : " + user.getName());
				return;
			}

		}

	}

	public User updateUser(User user, Integer userid) {

		User currentUser = getUserById(userid);

		if (currentUser != null) {

			if (currentUser.getId() != null) {

				currentUser.setHobbies(user.getHobbies());
				currentUser.setName(user.getName());
				currentUser.setDateOfBirth(user.getDateOfBirth());
				LOGGER.debug("Updated  User : " + user.getName());

			} else {
				LOGGER.debug("User found but Id == null. Adding it as new  User : " + user.getName());
				addUser(currentUser);
			}

		} else {

			LOGGER.debug("User not found to update. Adding it as new  User : " + user.getName());

			addUser(currentUser);
		}

		return getUserById(currentUser.getId());

	}

	public User addUser(User user) {
		
		users.add(user);
		LOGGER.debug("Added new  User : " + user.getName());
		return getUserById(user.getId());

	}

}
