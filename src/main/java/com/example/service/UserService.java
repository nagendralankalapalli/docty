package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.dto.UserDto;
import com.example.model.User;




public interface UserService {
	public ResponseEntity<?> registerUser(UserDto request);
	public ResponseEntity<?>  editRegistrationForm(UserDto request);
	public User getByUserId(long userId);
	public void deleteUser(long UserId);
	public List<User> getAllUsers();
}
