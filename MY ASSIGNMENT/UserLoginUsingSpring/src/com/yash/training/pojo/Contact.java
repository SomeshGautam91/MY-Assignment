package com.yash.training.pojo;

public class Contact extends Person {
	
	
	private int id;
	private String address;
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
