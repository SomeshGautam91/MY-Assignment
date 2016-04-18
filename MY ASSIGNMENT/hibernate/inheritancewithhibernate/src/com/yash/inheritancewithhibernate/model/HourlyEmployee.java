package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue(value="Hourly")
public class HourlyEmployee extends Employee 
{
	@Column(name="Hours_Of_Day")
	private float hours_Of_Day;
	
	@Column(name="Per_Hour_Pay")
	private double per_Hour_Pay;
	
	public float getHours_Of_Day() 
	{
		return hours_Of_Day;
	}
	public void setHours_Of_Day(float hours_Of_Day) 
	{
		this.hours_Of_Day = hours_Of_Day;
	}
	public double getPer_Hour_Pay()
	{
		return per_Hour_Pay;
	}
	public void setPer_Hour_Pay(double per_Hour_Pay) 
	{
		this.per_Hour_Pay = per_Hour_Pay;
	}
	
	
}
