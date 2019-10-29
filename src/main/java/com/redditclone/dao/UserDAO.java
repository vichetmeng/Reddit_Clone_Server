package com.redditclone.dao;

import java.util.List;

import com.redditclone.entity.UserEntity;
import com.redditclone.model.Post;

public interface UserDAO {
	public UserEntity getUser(Integer uid);
	public Integer login(String username, String password);
	public Integer register(String username, String password);
	public List<Post> getUpvotedPosts(Integer uid);
	public List<Post> getDownvotedPosts(Integer uid);
	public List<Post> getSavedPosts(Integer uid);
}
