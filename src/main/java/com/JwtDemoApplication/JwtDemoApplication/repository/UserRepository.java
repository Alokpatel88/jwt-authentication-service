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

//	User save(User user);
//	ArrayList<User> findAll();
	User findByUserName(String username);

//	@Query("SELECT u FROM User u WHERE u.age BETWEEN :minAge AND :maxAge")
//	List<User> findUsersBetweenAge(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

	@Query("SELECT u FROM User u")
	ArrayList<User> getAllUsers();

}
