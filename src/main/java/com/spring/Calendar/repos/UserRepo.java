package com.spring.Calendar.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.Calendar.models.User;


public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	
	
}
