package com.redditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redditclone.dao.TopicDAO;
import com.redditclone.dao.UserDAO;
import com.redditclone.model.User;

@SpringBootApplication
public class SpringStarter implements CommandLineRunner {
	@Autowired
	UserDAO userDAO;
	@Autowired
	TopicDAO topicDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************************* RUN CALLED *************************");
//		User u = userDAO.getAllUsers("vichetmeng");
//		if (u != null) {
//			System.out.println("Username: " + u.getUsername());
//			System.out.println("Password: " + u.getPassword());
//			System.out.println("Email: " + u.getEmail());
//			System.out.println("Date joined: " + u.getDateSignedUp().toLocaleString());
//			for(Comment c : u.getComments()) {
//				System.out.println("Comment id: " + c.getId());
//				System.out.println("Comment body: " + c.getBody());
//				System.out.println("Comment added date: " + c.getDateAdded().toLocaleString());
//			}
//		}
		// Register a user
//		User u = new User();
//		u.setEmail("vichet@infosys.com");
//		u.setUsername("vichetm");
//		u.setPassword("vichet123");
//		userDAO.register(u);
		
//		User u1 = new User();
//		u1.setEmail("khang@infosys.com");
//		u1.setUsername("khang");
//		u1.setPassword("khang123");
//		userDAO.register(u1);
//		
//		User u2 = new User();
//		u2.setEmail("roden@infosys.com");
//		u2.setUsername("roden");
//		u2.setPassword("roden123");
//		userDAO.register(u2);
		// Make a new topic
		System.out.println(userDAO.login("vichetmm", "vichet123"));
		
		// Make a new post
		
		
		
		// Make a new comment
	}

}
