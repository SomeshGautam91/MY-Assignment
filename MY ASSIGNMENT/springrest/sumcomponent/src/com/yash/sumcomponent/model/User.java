package com.yash.sumcomponent.model;

public class User 
{
	private int userId;
	private String name;
	private String location;
	
	
	public String getLocation()
	{
		return location;
	}
	public String getName()
	{
		return name;
	}
	
	public int getUserId()
	{
		return userId;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setUserId(int userId) 
	{
		this.userId = userId;
	}


}
