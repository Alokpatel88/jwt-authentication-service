package com.JwtDemoApplication.JwtDemoApplication.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserServices {
	@Autowired
	UserRepository userRepository;
	public ArrayList<User> getUsersList() {
		return userRepository.getAllUsers();
	}
}
