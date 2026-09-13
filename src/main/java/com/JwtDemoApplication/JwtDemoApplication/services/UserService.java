package com.JwtDemoApplication.JwtDemoApplication.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserService {
	// phle is class me direct pass DB me save krne ke liye use kiya tha,
	// now Bcrypt PasswordEncoder use krke password ko encode krke save krne ke liye
	// use kiya hai

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User saveUser(User user) {

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		// if We have role also set role for user and other details also set for user and save in DB

		return userRepository.save(user);
	}

	public ArrayList<User> getUsersList() {
		return userRepository.getAllUsers();
	}

	public User getUsersList(String userName) {
		return userRepository.findByUserName(userName);
	}

}
