package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.infy.entity.UserEntity;

import com.infy.model.User;


@Repository(value = "mobileDAO")
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT METHOD
	

	public List<User> getUserDetails() {
		Query q = entityManager
				.createQuery("SELECT u FROM UserEntity u");
		
		List<UserEntity> userEntityList = q.getResultList();

		List<User> userList = new ArrayList<>();
		if (userEntityList.isEmpty()) {
			return userList;
		}
		for (UserEntity ce : userEntityList) {
			User user = new User();
			user.setUid(ce.getUid());
			user.setFirstName(ce.getFirstName());
			user.setLastName(ce.getLastName());
			
			
			userList.add(user);
			
		}
		return userList;
	}
	
	
	public String insertUserDetails(User user) {
		UserEntity e1= new UserEntity();
		e1.setUid(user.getUid());
		e1.setFirstName(user.getFirstName());
		e1.setLastName(user.getLastName());
		entityManager.persist(e1);
		return "Insertion successful";
	}
	
	
	public String validateUserDetails(User user) {
		UserEntity ue= entityManager.find(UserEntity.class, user.getUid());
		if(ue!=null) {
			if (ue.getFirstName().equalsIgnoreCase(user.getFirstName()) && ue.getLastName().equalsIgnoreCase(user.getLastName())) {
				return "validation successful";
			}
		}
		return "validation failed";
	}
	
	
	
}
