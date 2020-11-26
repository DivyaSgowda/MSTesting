package com.infy.service;

import java.util.List;


import com.infy.model.User;

public interface UserService {

	

	public String getHello();

	public List<User> getUserDetails() ;

	public String insertUser(User user);

	public String validateUser(User user);

	

}
