package com.redditclone.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "topic")
public class TopicEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tid; 
	private String name; 
	private String rules;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="topicid")
	private List<PostEntity> postlist;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="blacklist", joinColumns=@JoinColumn(name="topicid"), 
	inverseJoinColumns = @JoinColumn(name="useruid"))
	private List<UserEntity> userBlacklist;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subredditmember", joinColumns=@JoinColumn(name="topicid"), 
	inverseJoinColumns = @JoinColumn(name="useruid"))
	private List<UserEntity> memberList;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subredditmember", joinColumns=@JoinColumn(name="topicid"), 
	inverseJoinColumns = @JoinColumn(name="useruid"))
	private List<UserEntity> monitorList;
	
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

	public List<PostEntity> getPostlist() {
		return postlist;
	}

	public void setPostlist(List<PostEntity> postlist) {
		this.postlist = postlist;
	}

	public List<UserEntity> getUserBlacklist() {
		return userBlacklist;
	}

	public void setUserBlacklist(List<UserEntity> userBlacklist) {
		this.userBlacklist = userBlacklist;
	}

	public List<UserEntity> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<UserEntity> memberList) {
		this.memberList = memberList;
	}

	public List<UserEntity> getMonitorList() {
		return monitorList;
	}

	public void setMonitorList(List<UserEntity> monitorList) {
		this.monitorList = monitorList;
	} 
	
}
