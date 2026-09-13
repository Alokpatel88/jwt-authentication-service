package com.JwtDemoApplication.JwtDemoApplication.controller;

import org.springframework.web.bind.annotation.RestController;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.services.UserServices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	@Autowired
	UserServices userServices;
	@GetMapping("/getUsersList")
	public ArrayList<User> getUsersList() {
		ArrayList<User> users = new ArrayList<>();
		return userServices.getUsersList();
	}
	
}
