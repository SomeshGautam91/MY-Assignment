package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TwoWheeler")
public class TwoWheeler extends Vehicle 
{
	
	@Column(name="steeringTwoWheeler_type")
	private String steeringTwoWheeler;
	
	public void setSteeringTwoWheeler(String steeringTwoWheeler)
	{
		this.steeringTwoWheeler = steeringTwoWheeler;
	}
	public String getSteeringTwoWheeler() 
	{
		return steeringTwoWheeler;
	}
}
