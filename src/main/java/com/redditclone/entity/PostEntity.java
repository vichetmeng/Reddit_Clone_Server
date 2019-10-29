package com.redditclone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String content;
	private String title;
	private Integer upvoteCount;
	private Integer downvoteCount;
	private String pictureUrl;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "useruid")
	private UserEntity user;
	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name = "postpid")
	private List<CommentEntity> commentsList;
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
	public List<CommentEntity> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<CommentEntity> commentsList) {
		this.commentsList = commentsList;
	}
	
}
