package com.redditclone.model;

import java.time.LocalDateTime;
import java.util.List;

import com.redditclone.entity.UserEntity;

public class Post {
	private Integer pid;
	private String content;
	private String title;
	private Integer upvoteCount;
	private Integer downvoteCount;
	private String pictureUrl;
	private UserEntity user;
	private List<Comment> commentsList;
	private LocalDateTime dateCreated;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getUpvoteCount() {
		return upvoteCount;
	}
	public void setUpvoteCount(Integer upvoteCount) {
		this.upvoteCount = upvoteCount;
	}
	public Integer getDownvoteCount() {
		return downvoteCount;
	}
	public void setDownvoteCount(Integer downvoteCount) {
		this.downvoteCount = downvoteCount;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
