package com.redditclone.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity {
	@Id
	private Integer id;
	private Integer parentCommentId;
	private Integer postId;
	private String username;
	private String content;
	private Date dateAdded;
	private Integer numOfUpvotes;
	private Integer numOfDownvotes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Integer getNumOfUpvotes() {
		return numOfUpvotes;
	}
	public void setNumOfUpvotes(Integer numOfUpvotes) {
		this.numOfUpvotes = numOfUpvotes;
	}
	public Integer getNumOfDownvotes() {
		return numOfDownvotes;
	}
	public void setNumOfDownvotes(Integer numOfDownvotes) {
		this.numOfDownvotes = numOfDownvotes;
	}
	
	
}	
