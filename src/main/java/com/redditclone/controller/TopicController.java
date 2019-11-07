package com.redditclone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redditclone.model.Post;
import com.redditclone.model.Topic;
import com.redditclone.model.User;

@RestController("topic")
public class TopicController {
	/**
	 * Creates topic and assign the user to be the monitor
	 * @param topic the topic to be created
	 * @param uid the creator of this topic
	 * @return return the integer id of the topic created
	 */
	@RequestMapping(value="/create/{uid}", method = RequestMethod.POST)
	public ResponseEntity<String> createTopic(@RequestBody Topic topic, @PathVariable Integer uid) {
		return null;
	}
	/**
	 * Get the topic from the database using the id
	 * @param topicId the id of the topic
	 * @return the topic object from the database, null if it doesn't exist
	 */
	@RequestMapping(value="/get/{topicId}", method = RequestMethod.GET)
	public ResponseEntity<Topic> getTopic(@PathVariable Integer topicId) {
		return null;
	}
	/**
	 * Get the posts belonging to the topic
	 * @param topicId the id of the topic
	 * @return list of Post objects, null if the topic doesn't exist
	 */
	@RequestMapping(value="/getposts/{topicId}", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getPostsInTopic(@PathVariable Integer topicId){
		return null;
	}
	/**
	 * Get the users who are part of this topic
	 * @param topicId the id of the topic
	 * @return list of User objects, null if the topic doesn't exist
	 */
	@RequestMapping(value="/getmembers/{topicId}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getMembersInTopic(@PathVariable Integer topicId) {
		return null;
	}
	@RequestMapping(value="/getmonitor/{topicId}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getMonitorsInTopic(@PathVariable Integer topicId) {
		return null;
	}
	/**
	 * Updates the topic details
	 * @param t the topic object
	 * @return the id of the topic, null if it failed to update
	 */
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateTopic(@RequestBody Topic t) {
		return null;
	}
	/**
	 * Delete the topic and its existing posts and comments from the DB
	 * @param tid the topic id
	 * @return true if it was successful, false if it failed and null if topic doesn't exist.
	 */
	@RequestMapping(value="/delete/{tid}", method = RequestMethod.DELETE)
	public Boolean deleteTopic(@PathVariable Integer tid) {
		return null;
	}
}
