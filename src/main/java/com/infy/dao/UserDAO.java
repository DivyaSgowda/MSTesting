package com.infy.dao;

import java.util.List;


import com.infy.model.User;

public interface UserDAO {
	
	

	public List<User> getUserDetails();

	public String insertUserDetails(User user) ;

	public String validateUserDetails(User user);
	
	
}
