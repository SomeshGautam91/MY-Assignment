package com.yash.training.pojo;

import java.io.Serializable;

public class JspJavaBean implements Serializable {
	
	private String name;
	private int contactNo;
	private String email;
	private String password;
	
	public JspJavaBean()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
