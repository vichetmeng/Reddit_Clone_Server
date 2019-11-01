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
	private Integer userid;
	private Integer topicid;
	
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
	
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getTopicid() {
		return topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	
}
