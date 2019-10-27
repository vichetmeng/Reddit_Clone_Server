package com.redditclone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerApi {
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
}