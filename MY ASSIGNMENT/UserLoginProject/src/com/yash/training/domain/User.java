package com.yash.training.domain;

import java.util.Date;



public class User {
	
	private String name;
	private String contactNo;
	private Date dob;
	private String address;
	private String userId;
	private String password;
	
	public User(String name, String contactNo, Date dob, String address,
			String userId, String password) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
		this.userId = userId;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
