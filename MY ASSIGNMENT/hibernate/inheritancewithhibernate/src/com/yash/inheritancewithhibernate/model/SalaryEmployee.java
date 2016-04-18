package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue(value="Salary")
public class SalaryEmployee extends Employee
{
	@Column(name="Annual_Salary")
	private double annual_Salary;

	public double getAnnual_Salary() 
	{
		return annual_Salary;
	}

	public void setAnnual_Salary(double annual_Salary) 
	{
		this.annual_Salary = annual_Salary;
	}
	
	
}
