package com.yash.hibernatewithmaven.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Vehicle")
public class Vehicle 
{
	@Id @GeneratedValue
	@Column(name="vehicle_id")
	private int id;
	@Column(name="vahicle_type")
	private String type;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="registration_id",unique=true)
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
