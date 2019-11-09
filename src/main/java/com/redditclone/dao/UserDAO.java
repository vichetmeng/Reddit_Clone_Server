package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.User;

/**
 * @author vichetmeng
 *
 */
public interface UserDAO {
	/**
	 * This function gets the user out using the id
	 * @param uid the user's id
	 * @return the user object
	 */
	public User getUser(Integer uid);
	/**
	 * This function logs the user and return user's id if successful.
	 * @param username the user's username.
	 * @param password the user's password.
	 * @return user's id if successful, null otherwise.
	 */
	public Integer login(String username, String password);
	/**
	 * This function check if the username is already existed in the database.
	 * @param username, the username that you want to check.
	 * @return true if it is already existed in DB, false otherwise.
	 */
	public Boolean usernameExists(String username);
	/**
	 * This function check if the user's email is already existed in the database.
	 * @param email, the email that you want to check.
	 * @return true if the email is already in the database, false otherwise.
	 */
	public Boolean emailExists(String email);
	/**
	 * This function registers the user.
	 * @param user object containing username, password and email of the user.
	 * @return the id of the user after it was inserted into the database.
	 */
	public Integer register(User user);
	/**
	 * This function finds all the post upvoted by the user
	 * @param uid the user id of the user
	 * @return a list of posts that were upvoted by the user.
	 */
	public List<Post> getUpvotedPosts(Integer uid);
	/**
	 * This function finds all the post downvoted by the user.
	 * @param uid the user id of the user.
	 * @return a list of posts that were downvoted by the user.
	 */
	public List<Post> getDownvotedPosts(Integer uid);
	/**
	 * This function finds all the post saved by the user.
	 * @param uid the user id of the user.
	 * @return a list of posts that were saved by the user.
	 */
	public List<Post> getSavedPosts(Integer uid);
	/**
	 * This function gets out all the posts posted by this user.
	 * @param uid, the id of the user
	 * @return the list of posts
	 */
	public List<Post> getPosts(Integer uid);
	/**
	 * This function allows the user to upvote a post, this will store the upvoted post in relation to the user
	 * as well as increment the upvotecount of the post.
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully upvoted the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean upvotePost(Integer uid, Integer pid);
	/**
	 * This function allows the user to downvote a post, this will store the downvoted post in relation to the user
	 * as well as increment the downvotecount of the post.
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully downvoted the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean downvotePost(Integer uid, Integer pid);
	/**
	 * This function allows the user to save a post
	 * @param uid the user's id
	 * @param pid the post's id
	 * @return true if it successfully saved the post, false otherwise (couldn't found the post or user).
	 */
	public Boolean savePost(Integer uid, Integer pid);
	/**
	 * This function allows the user to edit their email, password and avatar 
	 * @param user User model that gets from the front end 
	 * @return Boolean true if the operation is success  
	 * @throws Exception if we can't find the user  
	 */
	public Boolean updateUser(User user) throws Exception;
	/**
	 * 
	 * @param uid
	 * @return
	 */
	public Boolean deleteUser(Integer uid);
}
