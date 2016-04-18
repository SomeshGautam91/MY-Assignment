package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="vehicle")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Vehicle 
{
	@Id
	@GeneratedValue
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="vehicle_Name")
	private String vehicleName;

	public int getVehicleId()
	{
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) 
	{
		this.vehicleId = vehicleId;
	}

	public String getVehicleName()
	{
		return vehicleName;
	}

	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
	}
	
	
	
}
