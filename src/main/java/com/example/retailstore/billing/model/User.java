package com.example.retailstore.billing.model;




public class User {
	private Long id;
	private String name;
	private String phone;
	private UserType userType;
	public User(String name,String phone, UserType userType) {
		super();
		setName(name);
		setPhone(phone);
		setUserType(userType);
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
	
}
