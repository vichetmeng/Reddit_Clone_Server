package com.redditclone.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid; 
	private String content; 
	@Column(name="upvote_count")
	private Integer upvoteCount;
	@Column(name="downvote_count")
	private Integer downvoteCount;
	@Column(name = "date_created")
	private LocalDate dateCreated;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="parentcid")
	private CommentEntity parentComment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="useruid")
	private UserEntity user;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public CommentEntity getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentEntity parentComment) {
		this.parentComment = parentComment;
	}
	
}
