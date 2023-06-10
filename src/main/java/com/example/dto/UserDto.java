package com.example.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
	private long userId;
private String fullName;
private String emailId;
private String phoneNumber;
private String password;
private String confirmPassword;
private String gender;
private long age;
private String emergencyContectNumber;

}
