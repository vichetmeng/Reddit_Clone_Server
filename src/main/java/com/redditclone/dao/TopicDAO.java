package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.Topic;
import com.redditclone.model.User;

public interface TopicDAO {
	public Integer createTopic(Topic topic, Integer uid);
	public Topic getTopic(Integer topicId);
	public List<Post> getPostsInTopic(Integer topicId);
	public List<User> getMembersInTopic(Integer topicId);
	public Integer updateTopic(Topic t);
	public Boolean userIsMember(Integer topicId, Integer uid);
	public Boolean userIsMonitor(Integer topicId, Integer uid);
	public Boolean deleteTopic(Integer tid);
}
