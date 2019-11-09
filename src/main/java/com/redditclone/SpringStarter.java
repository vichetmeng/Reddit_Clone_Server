package com.redditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.redditclone.service.UserService;

@SpringBootApplication
//@PropertySource(value= {"classpath:messages.properties"})
public class SpringStarter implements CommandLineRunner {
//	@Autowired
//	UserService userService;
	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
//		try {
//			User u = new User();
//			u.setEmail("vichet@infosys.com");
//			u.setUsername("vichetm");
//			u.setPassword("vichet123");
//			userService.register(u);
//		} catch (Exception e) {
//			System.out.println(env.getProperty(e.getMessage()));
//		}
//		
////
//		
//		try {
//			User u1 = new User();
//			u1.setEmail("khang@infosys.com");
//			u1.setUsername("khang");
//			u1.setPassword("khang123");
//			userService.register(u1);
//		} catch (Exception e) {
//			System.out.println(env.getProperty(e.getMessage()));
//		}
//
//		User u2 = new User();
//		u2.setEmail("roden@infosys.com");
//		u2.setUsername("roden");
//		u2.setPassword("roden123");
//		userDAO.register(u2);
		// Make a new topic
//		System.out.println(userDAO.login("vichetmm", "vichet123"));
//		System.out.println(userDAO.usernameExists("vichetm"));
		// Make a new post
		// Make a new comment
	}

}
