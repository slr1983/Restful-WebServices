package com.sumit.restfulwebservices.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sumit.restfulwebservices.dao.UserJpaDao;
import com.sumit.restfulwebservices.dao.UserPostDao;
import com.sumit.restfulwebservices.exceptions.UserNotFoundException;
import com.sumit.restfulwebservices.models.Post;
import com.sumit.restfulwebservices.models.User;

@RestController
public class UserController {

	@Autowired
	private UserJpaDao userJpaDao;

	@Autowired
	private UserPostDao userPostDao;

	public UserController(UserPostDao userPostDao) {
		this.userPostDao = userPostDao;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userJpaDao.getAllUsers();

	}

	@GetMapping("/users/{userId}/posts")
	public List<Post> getAllUserPosts(@PathVariable String userId) {

		return userJpaDao.getPostsByUserId(Integer.valueOf(userId));

	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {

		return userPostDao.getAllPosts();

	}

	@GetMapping("/users/{userid}")
	public EntityModel<User> getUser(@PathVariable(name = "userid") String userId) {

		Optional<User> retrievedOptionalUser = userJpaDao.getUserById(Integer.valueOf(userId));

		if (retrievedOptionalUser.isEmpty() || retrievedOptionalUser.get() == null) {

			throw new UserNotFoundException("ID : " + userId);

		}

		User retrievedUser = retrievedOptionalUser.get();

		EntityModel<User> resource = EntityModel.of(retrievedUser);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());

		resource.add(linkTo.withRel("all-users"));
		// HATEOAS

		return resource;

	}

	@PostMapping("/users/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

		User savedUser = userJpaDao.addUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PostMapping("/users/{userId}/posts/add")
	public ResponseEntity<Post> addPost(@RequestBody Post post, @PathVariable String userId) {

		Optional<User> retrievedOptionalUser = userJpaDao.getUserById(Integer.valueOf(userId));

		if (retrievedOptionalUser.isEmpty() || retrievedOptionalUser.get() == null) {

			throw new UserNotFoundException("ID : " + userId);

		}

		User retrievedUser = retrievedOptionalUser.get();
		
		post.setUser(retrievedUser);
		
		userJpaDao.addUserPost(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postid}")
				.buildAndExpand(post.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PostMapping("/users/update/{userid}")
	public User updateUser(@PathVariable(name = "userid") String userId, @RequestBody User user) {

		return userJpaDao.updateUser(user, Integer.valueOf(userId));

	}

	@PostMapping("/users/{userid}/posts/{postId}/update")
	public User updateUserPost(@PathVariable(name = "userid") String userId, @PathVariable(name = "postId") String postId, @RequestBody Post post) {

		return userJpaDao.updateUserPost(post, Integer.valueOf(postId), Integer.valueOf(userId));

	}

	@PostMapping("/users/delete/{userid}")
	public void deleteUser(@PathVariable(name = "userid") String userId) {

		userJpaDao.deleteUserById(Integer.valueOf(userId));

	}

	@PostMapping("/users/{userId}/posts/{postId}/delete")
	public void deleteUserPost(@PathVariable(name = "userId") String userId,
			@PathVariable(name = "postId") String postId) {

		userJpaDao.deleteUserPostById(Integer.valueOf(postId), Integer.valueOf(userId));

	}

}
