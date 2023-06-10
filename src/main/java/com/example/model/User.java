package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_ID")
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
