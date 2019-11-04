package com.redditclone.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="blacklist", joinColumns=@JoinColumn(name="topicid"), 
	inverseJoinColumns = @JoinColumn(name="useruid"))
	private List<UserEntity> userBlacklist;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subredditmonitor", joinColumns=@JoinColumn(name="topicid"), 
	inverseJoinColumns = @JoinColumn(name="useruid"))
	private List<UserEntity> monitorList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="subredditmember",joinColumns=@JoinColumn(name="topicid"),
	inverseJoinColumns=@JoinColumn(name="useruid"))
	private List<TopicEntity> memberList;
	
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
	public List<UserEntity> getUserBlacklist() {
		return userBlacklist;
	}

	public void setUserBlacklist(List<UserEntity> userBlacklist) {
		this.userBlacklist = userBlacklist;
	}


	public List<UserEntity> getMonitorList() {
		return monitorList;
	}

	public void setMonitorList(List<UserEntity> monitorList) {
		this.monitorList = monitorList;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<TopicEntity> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<TopicEntity> memberList) {
		this.memberList = memberList;
	} 
	
}
