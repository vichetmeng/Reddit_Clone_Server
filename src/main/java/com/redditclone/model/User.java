package com.redditclone.model;

import java.util.Date;
import java.util.List;


public class User {
	private String username;
	private String email;
	private String password;
	private Date dateSignedUp;
	private List<Comment> comments;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Date getDateSignedUp() {
		return dateSignedUp;
	}
	public void setDateSignedUp(Date dateSignedUp) {
		this.dateSignedUp = dateSignedUp;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
