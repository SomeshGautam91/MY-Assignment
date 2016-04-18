package com.yash.simpleapplicationusinghibernate.model;

public class StudentAddress
{
	private int address_id;
	private String city;
	private String state;
	private long zip;
	
	public int getAddress_id()
	{
		return address_id;
	}
	public void setAddress_id(int address_id) 
	{
		this.address_id = address_id;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	public long getZip() 
	{
		return zip;
	}
	public void setZip(long zip)
	{
		this.zip = zip;
	}
	
	
	
	
}
