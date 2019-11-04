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

import com.redditclone.model.User;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	private String email;
	private String passwordHash;
	private String username;
	@Column(name = "avatar")
	private String avatarUrl;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_upvoted",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="postpid"))
	private List<PostEntity> postsUpvoted;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_downvoted",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="postpid"))
	private List<PostEntity> postsDownvoted;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_save",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="postpid"))
	private List<PostEntity> postsSaved;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subredditmember",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="topicid"))
	private List<TopicEntity> memberList;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="subredditmonitor",joinColumns=@JoinColumn(name="useruid"),inverseJoinColumns=@JoinColumn(name="topicid"))
	private List<TopicEntity> monitorList;
	
	private LocalDateTime dateJoined;
	
	public UserEntity() {	
	}
	
	public UserEntity(String email, String passwordHash, String username) {
		super();
		this.email = email;
		this.passwordHash = passwordHash;
		this.username = username;
	}
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

	public List<TopicEntity> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<TopicEntity> memberList) {
		this.memberList = memberList;
	}

	public List<TopicEntity> getMonitorList() {
		return monitorList;
	}

	public void setMonitorList(List<TopicEntity> monitorList) {
		this.monitorList = monitorList;
	}
	
}
