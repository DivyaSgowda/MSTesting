package com.infy.model;

public class User {
	private Integer uid;
	private String firstName;
	private String lastName;
	
	public User() {
		System.out.println("user model class");
	}
	
	public Integer getUid() {
		return uid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
}
