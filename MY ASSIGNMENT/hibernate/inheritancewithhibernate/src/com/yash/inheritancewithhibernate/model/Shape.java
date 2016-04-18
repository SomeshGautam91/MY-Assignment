package com.yash.inheritancewithhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Shapes")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Shape
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="shape_id")
	private int shapeId;
	
	@Column(name="shape_name")
	private String shapeName;
	
	public void setShapeName(String shapeName) 
	{
		this.shapeName = shapeName;
	}
	
	public String getShapeName()
	{
		return shapeName;
	}
}
