package com.sumit.restfulwebservices.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sumit.restfulwebservices.models.Post;
import com.sumit.restfulwebservices.models.User;
import com.sumit.restfulwebservices.repositories.PostRepository;
import com.sumit.restfulwebservices.repositories.UserRepository;

@Component
public class UserJpaDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserJpaDao.class);

	public List<User> getAllUsers() {

		LOGGER.debug(" UserJpaDao getAllUsers()");

		return userRepository.findAll();
	}

	public Optional<User> getUserById(Integer userId) {

		LOGGER.debug(" UserJpaDao getUserById.");

		return userRepository.findById(userId);

	}

	public void deleteUserById(Integer userId) {

		LOGGER.debug(" UserJpaDao deleteUserById");

		userRepository.deleteById(userId);

	}

	public User updateUser(User user, Integer userid) {

		LOGGER.debug(" UserJpaDao updateUser");

		Optional<User> currentOptionalUser = getUserById(userid);

		if (currentOptionalUser != null) {

			User currentUser = currentOptionalUser.get();

			if (currentUser != null) {

				if (currentUser.getId() != null) {

					currentUser.setHobbies(user.getHobbies());
					currentUser.setName(user.getName());
					currentUser.setDateOfBirth(user.getDateOfBirth());
					userRepository.save(currentUser);
					LOGGER.debug("Updated  User : " + user.getName());

				} else {
					LOGGER.debug("User found but Id == null. Adding it as new  User : " + user.getName());
					addUser(currentUser);
				}

			} else {

				LOGGER.debug("User not found to update. Adding it as new  User : " + user.getName());

				addUser(user);
			}

		}

		return null;

	}

	public User addUser(User user) {

		LOGGER.debug(" UserJpaDao addUser");

		return userRepository.save(user);

	}

	public UserJpaDao(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
		LOGGER.debug("Default Constructor UserDao");
	}

	public List<Post> getPostsByUserId(Integer userId) {

		Optional<User> fetchedOptionalUser = getUserById(userId);

		if (fetchedOptionalUser.isPresent()) {

			User fetchedUser = fetchedOptionalUser.get();

			return fetchedUser.getPosts();

		}
		return null;
	}

	public Post addUserPost(Post post) {
		
		
		return postRepository.save(post);
		
	}

	public User updateUserPost(Post post, Integer postId, Integer userId) {

		Optional<User> fetchedOptionalUser = getUserById(userId);

		if (fetchedOptionalUser.isPresent()) {

			User fetchedUser = fetchedOptionalUser.get();

			List<Post> existingUserPosts = fetchedUser.getPosts();

			for (Post currentPost : existingUserPosts) {

				if (currentPost.getId().equals(postId)) {

					currentPost.setPostmessage(post.getPostmessage());

					break;

				}

			}

			return userRepository.save(fetchedUser);

		}

		return null;

	}

	public void deleteUserPostById(Integer postId, Integer userId) {

		Optional<User> fetchedOptionalUser = getUserById(userId);

		if (fetchedOptionalUser.isPresent()) {

			User fetchedUser = fetchedOptionalUser.get();

			List<Post> existingUserPosts = fetchedUser.getPosts();

			for (Iterator<Post> iterator = existingUserPosts.iterator(); iterator.hasNext();) {
				Post post = (Post) iterator.next();

				if (post.getId().equals(postId)) {
					iterator.remove();
					break;
				}

			}

			userRepository.save(fetchedUser);

		}

	}

}
