package com.JwtDemoApplication.JwtDemoApplication.controller;

import org.springframework.web.bind.annotation.RestController;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.repository.UserRepository;
import com.JwtDemoApplication.JwtDemoApplication.security.CustomUserDetails;
import com.JwtDemoApplication.JwtDemoApplication.services.CustomUserServices;
import com.JwtDemoApplication.JwtDemoApplication.services.UserService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	@Autowired
	UserService userServices;
	
	private final CustomUserServices customUserServices;

	public UserController(CustomUserServices customUserServices) {
		this.customUserServices = customUserServices;
	}
	
	@PostMapping("/saveuser")
	private String saveUser(@RequestBody User user) {
		userServices.saveUser(user);
		return "User saved successfully";
	}
	
	@GetMapping("/getUsersList")
	public ArrayList<User> getUsersList() {
		ArrayList<User> users = new ArrayList<>();
		return userServices.getUsersList();
	}
	
	@GetMapping("/getUserByUserName")
	public User getUserByUserName(@RequestParam String userName) {
		return userServices.getUsersList(userName);
	}
	
	// get data according to JWT CustomUserServices - userDetails
	@GetMapping("/getUserDetails")
	public CustomUserDetails getUserDetails(@RequestParam String userName) {
		return customUserServices.loadUserByUsername(userName);
	}
	
}
