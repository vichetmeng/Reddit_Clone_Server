package com.redditclone.service;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.Topic;
import com.redditclone.model.User;

public interface TopicService {
	/**
	 * Creates topic and assign the user to be the monitor
	 * @param topic the topic to be created
	 * @param uid the creator of this topic
	 * @return return the integer id of the topic created
	 */
	public Integer createTopic(Topic topic, Integer uid);
	/**
	 * Get the topic from the database using the id
	 * @param topicId the id of the topic
	 * @return the topic object from the database, null if it doesn't exist
	 */
	public Topic getTopic(Integer topicId);
	/**
	 * Get the posts belonging to the topic
	 * @param topicId the id of the topic
	 * @return list of Post objects, null if the topic doesn't exist
	 */
	public List<Post> getPostsInTopic(Integer topicId);
	/**
	 * Get the users who are part of this topic
	 * @param topicId the id of the topic
	 * @return list of User objects, null if the topic doesn't exist
	 */
	public List<User> getMembersInTopic(Integer topicId);
	public List<User> getMonitorsInTopic(Integer topicId);
	/**
	 * Updates the topic details
	 * @param t the topic object
	 * @return the id of the topic, null if it failed to update
	 */
	public Integer updateTopic(Topic t);
	/**
	 * Delete the topic and its existing posts and comments from the DB
	 * @param tid the topic id
	 * @return true if it was successful, false if it failed and null if topic doesn't exist.
	 */
	public Boolean deleteTopic(Integer tid);
	
}
