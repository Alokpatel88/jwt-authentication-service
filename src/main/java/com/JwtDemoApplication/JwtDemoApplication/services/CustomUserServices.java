package com.JwtDemoApplication.JwtDemoApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.repository.UserRepository;
import com.JwtDemoApplication.JwtDemoApplication.security.CustomUserDetails;

public class CustomUserServices implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName)
	        throws UsernameNotFoundException {

	    User user = userRepository.findByUserName(userName);

	    if (user == null) {
	        throw new UsernameNotFoundException("User not found");
	    }

	    return new CustomUserDetails(user);
	}
	
	
}
