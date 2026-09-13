package com.JwtDemoApplication.JwtDemoApplication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.JwtDemoApplication.JwtDemoApplication.Entity.User;

@Repository
@EnableJpaRepositories
@Component
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u")
	ArrayList<User> getAllUsers();
	
	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	User findByUserName(@Param("userName") String userName);
	
//	@Query("SELECT u FROM User u WHERE u.id = :id")
//	User findById(@Param("id") Integer id);
}
