package com.redditclone.dao;

import java.util.List;

import com.redditclone.model.Post;
import com.redditclone.model.Topic;
import com.redditclone.model.User;

public interface TopicDAO {
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
	/**
	 * Updates the topic details
	 * @param t the topic object
	 * @return the id of the topic, null if it failed to update
	 */
	public Integer updateTopic(Topic t);
	/**
	 * Checks if a user is a member of a topic
	 * @param topicId id of the topic
	 * @param uid user's id
	 * @return true if user is a member, false if user is not a member and null if topic does not exist.
	 */
	public Boolean userIsMember(Integer topicId, Integer uid);
	/**
	 * Checks if a user is a monitor of a topic
	 * @param topicId id of the topic
	 * @param uid user's id
	 * @return true if user is a monitor, false if user is not a monitor and null if topic does not exist.
	 */
	public Boolean userIsMonitor(Integer topicId, Integer uid);
	/**
	 * Delete the topic and its existing posts and comments from the DB
	 * @param tid the topic id
	 * @return true if it was successful, false if it failed and null if topic doesn't exist.
	 */
	public Boolean deleteTopic(Integer tid);
}
