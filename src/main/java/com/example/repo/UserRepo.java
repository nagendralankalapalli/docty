package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;



public interface UserRepo extends CrudRepository<User, Long> {
	User findByEmailId(String emailId);
	
	User getUserByUserId(long userId);
	




}
