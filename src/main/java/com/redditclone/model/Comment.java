package com.redditclone.model;

import java.util.Date;

public class Comment {
	private int id;
	private String body;
	private Date dateAdded;
	private int numOfUpvotes;
	private int numOfDownvotes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public int getNumOfUpvotes() {
		return numOfUpvotes;
	}
	public void setNumOfUpvotes(int numOfUpvotes) {
		this.numOfUpvotes = numOfUpvotes;
	}
	public int getNumOfDownvotes() {
		return numOfDownvotes;
	}
	public void setNumOfDownvotes(int numOfDownvotes) {
		this.numOfDownvotes = numOfDownvotes;
	}
	
}
