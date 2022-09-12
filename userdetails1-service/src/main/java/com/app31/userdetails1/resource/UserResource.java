package com.app31.userdetails1.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")

public class UserResource {
	
	@GetMapping(value = "/home")
	public String showUser() {
		return "Application Works!";		
	}
}