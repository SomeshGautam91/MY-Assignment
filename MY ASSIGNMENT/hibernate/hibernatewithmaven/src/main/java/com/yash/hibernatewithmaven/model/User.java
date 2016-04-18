package com.yash.hibernatewithmaven.model;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "USER")
public class User 
{
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Embedded
	private  Address address;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="vehicle_id",unique=true)
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
