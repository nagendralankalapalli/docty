package com.example.controller;



import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repo.UserRepo;
import com.example.service.UserService;




@Controller
public class UserController {
	@Autowired
	private UserRepo repo;
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		
		List<User> request=service.getAllUsers();
		m.addAttribute("request",request);
		
	   return "index";
	}
	
	@GetMapping("/addUser")
	public String addEmpForm()
	{
		return "user_register";
	}

	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute UserDto request, HttpSession session)
	{
		
		
		User model=repo.findByEmailId(request.getEmailId());
		try {
		if(model!=null) {
			session.setAttribute("msg", "User Already existed");
			return "redirect:/";
			
		}else {
		
		service.registerUser(request);
		session.setAttribute("msg", "User Added Succesfully");
		
		return "redirect:/";
		}} catch (Exception e) {
			// An error occurred while processing hiring request
			
			session.setAttribute("msg", "User notAdded Succesfully");
			return "redirect:/";
		}
	}
	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable long userId,HttpSession session)
	{
		
		try {
			service.deleteUser(userId);
			session.setAttribute("msg", "Form Deleted Succesfully");
			return "redirect:/";
		}catch(Exception e) {
			
			session.setAttribute("msg", "User Id Is NotExisted");
			return "redirect:/";	
		}
		
		
	}
	
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable long userId,Model m,HttpSession session)
	{
		User user=repo.getUserByUserId(userId);
		if(user!=null) {
		 user=service.getByUserId(userId);
		m.addAttribute("user",user);
		return "edit";
		}else {
			session.setAttribute("msg", "User Id Is NotExisted");
			return "redirect:/";	
			
		}
		
	}
	@PostMapping("/update")
	public String updateUser(@ModelAttribute UserDto formDto,HttpSession session)
	{
		
		try {
		service.editRegistrationForm(formDto);
		session.setAttribute("msg", "Form updated Succesfully");
		return "redirect:/";
		}catch(Exception e) {
			
			session.setAttribute("msg", "Form notUpdated Succesfully");
			return "redirect:/";	
		}
	}
}
