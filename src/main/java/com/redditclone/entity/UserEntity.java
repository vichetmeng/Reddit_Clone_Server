package com.redditclone.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	private String email;
	private String passwordHash;
	private String username;
	@Column(name = "avatar")
	private String avatarUrl;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="useruid")
	private List<PostEntity> postList;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_upvoted",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="postpid"))
	private List<PostEntity> postsUpvoted;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_downvoted",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="postpid"))
	private List<PostEntity> postsDownvoted;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_save",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="postpid"))
	private List<PostEntity> postsSaved;
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
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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
	public List<PostEntity> getPostList() {
		return postList;
	}
	public void setPostList(List<PostEntity> postList) {
		this.postList = postList;
	}
	public List<PostEntity> getPostsUpvoted() {
		return postsUpvoted;
	}
	public void setPostsUpvoted(List<PostEntity> postsUpvoted) {
		this.postsUpvoted = postsUpvoted;
	}
	public List<PostEntity> getPostsDownvoted() {
		return postsDownvoted;
	}
	public void setPostsDownvoted(List<PostEntity> postsDownvoted) {
		this.postsDownvoted = postsDownvoted;
	}
	public List<PostEntity> getPostsSaved() {
		return postsSaved;
	}
	public void setPostsSaved(List<PostEntity> postsSaved) {
		this.postsSaved = postsSaved;
	}
	public LocalDateTime getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(LocalDateTime dateJoined) {
		this.dateJoined = dateJoined;
	}
	
	
}
