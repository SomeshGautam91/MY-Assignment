package com.bean;

public class NewUser
{
	private String name;
	private Address permAddress;
	
	public NewUser(String name, Address permAddress) 
	{
		super();
		this.name = name;
		this.permAddress = permAddress;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(Address permAddress) {
		this.permAddress = permAddress;
	}
	public void displayInfo()
	{
		System.out.println("name "+getName());
		System.out.println("HouseNo "+getPermAddress().getHouseNo());
		System.out.println("Street "+getPermAddress().getStreet());
		System.out.println("City "+getPermAddress().getCity());
		
	}
	
	
}
