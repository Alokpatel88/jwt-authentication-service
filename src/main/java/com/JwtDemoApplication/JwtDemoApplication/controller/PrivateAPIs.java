package com.JwtDemoApplication.JwtDemoApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.repository.UserRepository;


@RestController
public class PrivateAPIs {
	
//	@Autowired
//	private UserRepository userRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/privateAPI1")
	public String privateAPI() {
		return "This is a private API";

	}
	
	@GetMapping("/privateAPI2")
	public String privateAPI2() {
		return "This is a private API 2 password protected";

	}
	@PostMapping("/saveuser1")
	private String saveUser1(@RequestBody User user) {
		User user1 = new User();
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		System.out.println("User name: " + user1.getUserName() + " Password: " + user1.getPassword());
		userRepository.save(user1);
		return "User saved successfully";
	}
}
