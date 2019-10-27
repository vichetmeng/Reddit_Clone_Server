package com.redditclone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	private String username;
	private String email;
	private String password;
	private Date dateSignedUp;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="username")
	private List<CommentEntity> comments;
	public Date getDateSignedUp() {
		return dateSignedUp;
	}
	public void setDateSignedUp(Date dateSignedUp) {
		this.dateSignedUp = dateSignedUp;
	}
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
	public List<CommentEntity> getComments() {
		return comments;
	}
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	
	
}
