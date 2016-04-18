package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="FourWheeler")
public class FourWheeler extends Vehicle 
{
	@Column(name="steeringFourWheeler_type")
	private String steeringFourWheeler;
	
	public void setSteeringFourWheeler(String steeringFourWheeler) 
	{
		this.steeringFourWheeler = steeringFourWheeler;
	}
	public String getSteeringFourWheeler() 
	{
		return steeringFourWheeler;
	}
}
