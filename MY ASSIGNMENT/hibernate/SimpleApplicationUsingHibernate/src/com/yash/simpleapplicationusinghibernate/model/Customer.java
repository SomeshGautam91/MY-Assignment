package com.yash.simpleapplicationusinghibernate.model;

public class Customer 
{
	private int id;
	private String name;
	private  Address address;
	private Vehicle vehicle;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Address getAddress()
	{
		return address;
	}
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
	
	
	
}
