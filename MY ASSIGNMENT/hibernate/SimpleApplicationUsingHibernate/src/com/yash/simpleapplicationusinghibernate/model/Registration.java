package com.yash.simpleapplicationusinghibernate.model;

public class Registration 
{
	private int id;
	private String registrationCity;
	private String registrationState;
	private int seriesNo;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getRegistrationCity() 
	{
		return registrationCity;
	}
	public void setRegistrationCity(String registrationCity)
	{
		this.registrationCity = registrationCity;
	}
	public String getRegistrationState() 
	{
		return registrationState;
	}
	public void setRegistrationState(String registrationState)
	{
		this.registrationState = registrationState;
	}
	public int getSeriesNo()
	{
		return seriesNo;
	}
	public void setSeriesNo(int seriesNo) 
	{
		this.seriesNo = seriesNo;
	}
	
	
	
	
}
