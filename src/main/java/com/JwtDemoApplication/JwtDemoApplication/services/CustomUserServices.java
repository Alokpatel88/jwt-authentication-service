package com.JwtDemoApplication.JwtDemoApplication.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;
import com.JwtDemoApplication.JwtDemoApplication.repository.UserRepository;
import com.JwtDemoApplication.JwtDemoApplication.security.CustomUserDetails;

@Service
public class CustomUserServices implements UserDetailsService {
//	@Autowired
//	UserRepository userRepository;
	
	private final UserRepository userRepository;

    public CustomUserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public CustomUserDetails loadUserByUsername(String userName)
	        throws UsernameNotFoundException {

	    User user = userRepository.findByUserName(userName);

	    if (user == null) {
	        throw new UsernameNotFoundException("User not found!!..");
	    }

	    return new CustomUserDetails(user);
	}
	
	
}
