package com.yash.hibernatewithmaven.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Registration")
public class Registration 
{
	@Id @GeneratedValue
	@Column(name="registration_id")
	private int id;
	
	@Column(name="registration_City")
	private String registrationCity;
	
	@Column(name="registration_State")
	private String registrationState;
	
	@Column(name="series_No")
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
