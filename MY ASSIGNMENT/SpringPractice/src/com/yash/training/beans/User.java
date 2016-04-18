package com.yash.training.beans;

public class User 
{
	int userId;
	String name;
	Address homeAddress;
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void showDetails()
	{
		System.out.println("UserId:"+getUserId());
		System.out.println("Name:"+getName());
		System.out.println("---------Home Address Info-----------");
		System.out.println("Street:"+homeAddress.getStreet());
		System.out.println("City:"+homeAddress.getCity());
		System.out.println("Pin:"+homeAddress.getPin());
	}
	
	
}
