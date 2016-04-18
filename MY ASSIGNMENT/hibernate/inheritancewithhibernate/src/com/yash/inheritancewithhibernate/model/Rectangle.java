package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Rectangle")
public class Rectangle extends Shape
{
	/*@Id
	@GeneratedValue
	@Column(name="rectangle_id")
	private int rectangleId;*/
	
	@Column(name="Rectangle_length")
	private float length;
	
	@Column(name="Rectangle_breadth")
	private float breadth;
	
	
	public float getLength() 
	{
		return length;
	}
	public void setLength(float length) 
	{
		this.length = length;
	}
	public float getBreadth()
	{
		return breadth;
	}
	public void setBreadth(float breadth) 
	{
		this.breadth = breadth;
		
	}
	
	
}
