package com.yash.training.pojo;

import java.util.Date;

public class UserPojo {
	
	
	private String name;
	private String contactNo;
	private String dob;
	private String email;
	private String street;
	private String city;
	private String houseNo;
	private String username;
	private String password;
	
	public UserPojo(String name, String contactNo, String dob, String email,
			String street, String city, String houseNo, String username,
			String password) {
		
		this.name = name;
		this.contactNo = contactNo;
		this.dob = dob;
		this.email = email;
		this.street = street;
		this.city = city;
		this.houseNo = houseNo;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	

}
