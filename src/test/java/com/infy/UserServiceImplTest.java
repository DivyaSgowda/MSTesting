package com.infy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import com.infy.dao.UserDAO;
import com.infy.model.User;
import com.infy.service.UserServiceImpl;

public class UserServiceImplTest {
    
	@InjectMocks
	private UserServiceImpl userservice;
	
	@Mock
	private UserDAO userDAO;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getHelloTest() {
		String resp=userservice.getHello();
		Assert.assertEquals(resp, "Hello World");
	}
	
	@Test
	public void getUserDetailsTest() {
		
		List<User> userlist = new ArrayList<User>();
		User user1 = new User();
		user1.setUid(1);
		userlist.add(user1);
		Mockito.when(userDAO.getUserDetails()).thenReturn((List<User>) userlist);
		List<User> actuallist= userservice.getUserDetails();
		Assert.assertEquals(userlist.size(), actuallist.size());
	}
	
	@Test
	public void insertUserTest() {
		User user = new User();
		user.setUid(1);
		Mockito.when(userDAO.insertUserDetails(user)).thenReturn("Insertion successful");
		String actual=userservice.insertUser(user);
		Assert.assertEquals(actual,"Insertion successful");
	}
	@Test
	public void insertUserNullTest() {
		User user = null;
//		user.setUid(1);
		Mockito.when(userDAO.insertUserDetails(user)).thenReturn("Service.Insertion not successfull");
		String actual=userservice.insertUser(user);
		Assert.assertEquals(actual,"Service.Insertion not successfull");
	}
	
	@Test
	public void validateUserTest() {
		User user = new User();
		user.setUid(1);
		user.setFirstName("mark");
		user.setLastName(".");
		Mockito.when(userDAO.validateUserDetails(user)).thenReturn("validation successful");
		String actual= userservice.validateUser(user);
		Assert.assertEquals(actual, "validation successful");
	}
	
	@Test
	public void validateUserinvavlidTest() {
		User user = new User();
		Mockito.when(userDAO.validateUserDetails(user)).thenReturn("validation failed");
		String actual= userservice.validateUser(user);
		Assert.assertEquals(actual, "Service.validation failed");
	}
}
