package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Circle")
public class Circle extends Shape 
{
	/*@Id
	@GeneratedValue
	@Column(name="circle_id")
	private int circleId;*/
	
	@Column(name="Circle_Radius")
	private float circleRadius;
	
	public void setCircleRadius(float circleRadius)
	{
		this.circleRadius = circleRadius;
	}
	
	public float getCircleRadius() 
	{
		return circleRadius;
	}
}
