package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.User;

public interface UserDAO {
	public User getUser(Integer uid);
	public Integer login(String username, String password);
	public Integer register(User user);
	public List<Post> getUpvotedPosts(Integer uid);
	public List<Post> getDownvotedPosts(Integer uid);
	public List<Post> getSavedPosts(Integer uid);
}
