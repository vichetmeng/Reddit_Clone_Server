package com.redditclone.model;

import java.time.LocalDateTime;
import java.util.List;



public class Topic {
	private Integer tid; 
	private String name; 
	private String rules;
	private String description;
	private List<Post> postlist;
	private List<User> userBlacklist;
	private List<User> memberList;
	private List<User> monitorList;
	private LocalDateTime dateCreated;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Post> getPostlist() {
		return postlist;
	}
	public void setPostlist(List<Post> postlist) {
		this.postlist = postlist;
	}
	public List<User> getUserBlacklist() {
		return userBlacklist;
	}
	public void setUserBlacklist(List<User> userBlacklist) {
		this.userBlacklist = userBlacklist;
	}
	public List<User> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<User> memberList) {
		this.memberList = memberList;
	}
	public List<User> getMonitorList() {
		return monitorList;
	}
	public void setMonitorList(List<User> monitorList) {
		this.monitorList = monitorList;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
