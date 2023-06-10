package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.ErrorResponseDto;
import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	public ResponseEntity<?> registerUser(UserDto request) {
		ErrorResponseDto response = new ErrorResponseDto();
		User model = new User();
		model.setFullName(request.getFullName());
		model.setGender(request.getGender());
		model.setPhoneNumber(request.getPhoneNumber());
		model.setEmailId(request.getEmailId());
		model.setPassword(request.getPassword());
		model.setConfirmPassword(request.getConfirmPassword());
		model.setGender(request.getGender());
		model.setAge(request.getAge());
		model.setEmergencyContectNumber(request.getEmergencyContectNumber());
		repo.save(model);
		return ResponseEntity.ok(response);

	}

	@Override
	public ResponseEntity<?> editRegistrationForm(UserDto request) {
		ErrorResponseDto response = new ErrorResponseDto();
		User model = new User();		
		model=repo.getUserByUserId(request.getUserId());
		if(model!=null) {
		model.setFullName(request.getFullName());
		model.setGender(request.getGender());
		model.setPhoneNumber(request.getPhoneNumber());
		model.setEmailId(request.getEmailId());
		model.setPassword(request.getPassword());
		model.setConfirmPassword(request.getConfirmPassword());
		model.setGender(request.getGender());
		model.setAge(request.getAge());
		model.setEmergencyContectNumber(request.getEmergencyContectNumber());
		repo.save(model);
		}
		return ResponseEntity.ok(response);
	}

	public User getByUserId(long userId) {

		return repo.getUserByUserId(userId);
	}

	public void deleteUser(long UserId) {

		repo.deleteById(UserId);

	}



	@Override
	public List<User> getAllUsers() {
		List<User> list=  (List<User>) repo.findAll();
		return list;
		
	}



	

}
