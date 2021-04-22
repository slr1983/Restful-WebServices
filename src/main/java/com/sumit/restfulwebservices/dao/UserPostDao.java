package com.sumit.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sumit.restfulwebservices.models.Post;

@Component
public class UserPostDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserPostDao.class);

	//private UserDao userDao = new UserDao();

	private static List<Post> posts = new ArrayList<>();

	//private static Integer currentPostId = 1;

	/*
	 * public List<Post> getAllUserPosts(Integer userId) {
	 * 
	 * LOGGER.debug("Getting All User Posts.");
	 * 
	 * List<Post> userPosts = new ArrayList<>();
	 * 
	 * for (Iterator<Post> iterator = posts.iterator(); iterator.hasNext();) { Post
	 * post = iterator.next(); if (post.getUserId().equals(userId)) {
	 * userPosts.add(post); }
	 * 
	 * }
	 * 
	 * return userPosts; }
	 */

	public List<Post> getAllPosts() {

		return posts;
	}

	/*
	 * public Post getPostsByUserId(Integer postId, Integer userId) {
	 * 
	 * List<Post> userPosts = userDao.getPostsByUserId(userId);
	 * 
	 * for (Post post : userPosts) {
	 * 
	 * if (post.getId().equals(postId)) {
	 * 
	 * LOGGER.debug("Got Post : " + post.getPostmessage());
	 * 
	 * return post; }
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */

	/*
	 * public void deleteUserPostById(Integer postId, Integer userId) {
	 * 
	 * List<Post> userPosts = userDao.getPostsByUserId(userId);
	 * 
	 * for (Iterator<Post> iterator = userPosts.iterator(); iterator.hasNext();) {
	 * Post post = iterator.next(); if (post.getId().equals(postId)) {
	 * iterator.remove(); LOGGER.debug("Successfully deleted User Post : " +
	 * post.getPostmessage()); return; }
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public Post updateUserPost(Post post, Integer postId, Integer userId) {
	 * 
	 * List<Post> userPosts = userDao.getPostsByUserId(userId);
	 * 
	 * if (userPosts != null && !userPosts.isEmpty()) {
	 * 
	 * for (Post currentUserPost : userPosts) {
	 * 
	 * if (currentUserPost.getId() != null &&
	 * currentUserPost.getId().equals(postId)) {
	 * 
	 * currentUserPost.setPostmessage(post.getPostmessage());
	 * LOGGER.debug("Updated  User : " + post.getPostmessage());
	 * 
	 * break;
	 * 
	 * } else { LOGGER.debug("User found but Id == null. Adding it as new  User : "
	 * + post.getPostmessage()); addUserPost(currentUserPost, userId); }
	 * 
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * LOGGER.debug("User not found to update. Adding it as new  User : " +
	 * post.getPostmessage());
	 * 
	 * addUserPost(post, userId); }
	 * 
	 * return getPostsByUserId(post.getId(), post.getUserId());
	 * 
	 * }
	 */

	/*
	 * public Post addUserPost(Post post, Integer userId) {
	 * 
	 * post.setUserId(userId); posts.add(post);
	 * LOGGER.debug("Added new  Post to all Posts list: " + post.getPostmessage());
	 * List<Post> userPosts = userDao.getPostsByUserId(userId); userPosts.add(post);
	 * LOGGER.debug("Added new  Post to specific User : " + post.getPostmessage());
	 * return getPostsByUserId(post.getId(), post.getUserId());
	 * 
	 * }
	 */
	/*
	 * public static List<Post> generatePostsForUser(Integer userId) {
	 * 
	 * List<Post> posts = new ArrayList<>();
	 * 
	 * for (int i = 0; i < 6; i++) {
	 * 
	 * posts.add(new Post("User : " + userId + " , Post No :  " + (i + 1),
	 * currentPostId, userId));
	 * 
	 * currentPostId++;
	 * 
	 * }
	 * 
	 * return posts;
	 * 
	 * }
	 */

	UserPostDao() {
		LOGGER.debug("Default Constructor UserPostDao Starts");
		//// userDao.getUserById(1).setPosts(generatePostsForUser(1));
		// userDao.getUserById(2).setPosts(generatePostsForUser(2));
		/// userDao.getUserById(3).setPosts(generatePostsForUser(3));
		// userDao.getUserById(4).setPosts(generatePostsForUser(4));
		//posts.addAll(generatePostsForUser(1));
		//posts.addAll(generatePostsForUser(2));
		//posts.addAll(generatePostsForUser(3));
		//posts.addAll(generatePostsForUser(4));
		LOGGER.debug("Default Constructor UserPostDao Ends");
	}

}
