package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



import com.infy.model.User;

import com.infy.service.UserService;

@RestController
public class UserAppAPI {	
	

	public UserAppAPI() {
		// TODO Auto-generated constructor stub
		System.out.println("In con");
	}
	@Autowired
	private UserService userService;	
	
	
	@Autowired
	public Environment environment;
	
	@RequestMapping(value="/Hello",method = RequestMethod.GET)
	public String getHello() {
		String s1="Hello World!";
//		String s1=userService.getHello();
		return s1;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUserDetails()
			{	
			List<User> users = userService.getUserDetails();			
			return users;
	}
	@PostMapping(value = "/addusers",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertUser(@RequestBody User user){
		
			String s1= userService.insertUser(user);		
			return s1;		
	}
	
	@PostMapping(value = "/validate",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validateUser(@RequestBody User user){
		
			String s1= userService.validateUser(user);
			return s1;	
		
	}
	
}
