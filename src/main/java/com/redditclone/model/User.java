package com.redditclone.model;

import java.time.LocalDateTime;
import java.util.List;

import com.redditclone.entity.UserEntity;

public class User {
	private Integer uid;
	private String email;
	private String password;
	private String username;
	private String avatarUrl;
	
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
	
	public LocalDateTime getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(LocalDateTime dateJoined) {
		this.dateJoined = dateJoined;
	}
	
}
