package com.redditclone.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.redditclone")
public class SpringStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

}
