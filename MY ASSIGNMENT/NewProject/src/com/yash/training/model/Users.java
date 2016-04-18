package com.yash.training.model;

public class Users {
	
	String name;
	String contact;
	String email;
	
	
	public Users(String name, String contact, String email) 
	{
		this.name = name;
		this.contact = contact;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
