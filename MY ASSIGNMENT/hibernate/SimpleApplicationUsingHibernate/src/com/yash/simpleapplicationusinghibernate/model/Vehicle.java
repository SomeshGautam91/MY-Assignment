package com.yash.simpleapplicationusinghibernate.model;

public class Vehicle 
{
	private int id;
	private String type;
	private Registration registration;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public Registration getRegistration() 
	{
		return registration;
	}
	public void setRegistration(Registration registration) 
	{
		this.registration = registration;
	}
	
	
	
}
