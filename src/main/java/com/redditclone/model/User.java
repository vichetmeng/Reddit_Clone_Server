package com.redditclone.model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
	private Integer uid;
	private String email;
	private String password;
	private String username;
	private String avatarUrl;
	private List<Post> postList;
	private List<Post> postsUpvoted;
	private List<Post> postsDownvoted;
	private List<Post> postsSaved;
	private List<Topic> topicList;
	private LocalDateTime dateJoined;
	
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	public List<Post> getPostsUpvoted() {
		return postsUpvoted;
	}
	public void setPostsUpvoted(List<Post> postsUpvoted) {
		this.postsUpvoted = postsUpvoted;
	}
	public List<Post> getPostsDownvoted() {
		return postsDownvoted;
	}
	public void setPostsDownvoted(List<Post> postsDownvoted) {
		this.postsDownvoted = postsDownvoted;
	}
	public List<Post> getPostsSaved() {
		return postsSaved;
	}
	public void setPostsSaved(List<Post> postsSaved) {
		this.postsSaved = postsSaved;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	public LocalDateTime getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(LocalDateTime dateJoined) {
		this.dateJoined = dateJoined;
	}
	
}
