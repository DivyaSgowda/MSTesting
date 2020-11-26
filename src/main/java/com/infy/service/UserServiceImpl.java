package com.infy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.UserDAO;

import com.infy.model.User;



@Service(value = "mobileService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public UserServiceImpl() {
		System.out.println("in ser");
	}
	
	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT METHOD
	
	public String getHello() {
		
		return "Hello World";
	}
	
	
	public List<User> getUserDetails()  {
		List<User> userList = userDAO.getUserDetails();
		return userList;
	}
	

	public String insertUser(User user)  {
		String s1= userDAO.insertUserDetails(user);
		if (s1==null) {
			return "Service.Insertion not successfull";
		}
		return s1;
	}

	public String validateUser(User user) {
		String s1= userDAO.validateUserDetails(user);
		if (s1.equalsIgnoreCase("validation failed")) {
			return "Service.validation failed";
		}
		return s1;
	}

	
}
