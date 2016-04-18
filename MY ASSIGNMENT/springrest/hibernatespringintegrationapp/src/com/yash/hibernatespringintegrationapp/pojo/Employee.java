package com.yash.hibernatespringintegrationapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Employee 
{
	@Id
	private int id;
	
	
	private String name;
	
	
	private long contact;
	
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
	public long getContact() 
	{
		return contact;
	}
	public void setContact(long contact) 
	{
		this.contact = contact;
	}
	
	
}
