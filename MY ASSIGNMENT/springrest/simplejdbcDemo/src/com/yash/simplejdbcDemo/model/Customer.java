package com.yash.simplejdbcDemo.model;

public class Customer 
{
	private int customer_id;
	private String customer_name;
	private Address customer_address;
	
	public int getCustomer_id() 
	{
		return customer_id;
	}
	public void setCustomer_id(int customer_id) 
	{
		this.customer_id = customer_id;
	}
	public String getCustomer_name() 
	{
		return customer_name;
	}
	public void setCustomer_name(String customer_name) 
	{
		this.customer_name = customer_name;
	}
	public Address getCustomer_address() 
	{
		return customer_address;
	}
	public void setCustomer_address(Address customer_address) 
	{
		this.customer_address = customer_address;
	}
	
	



}
