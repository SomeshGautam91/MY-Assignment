package com.yash.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserDetails 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long contact;
	private String address;
	
	private Date dateOfBirth;
	@Column(columnDefinition="INT")
	private boolean status;
	@Column(columnDefinition="LONGBLOB")
	private String shortDescription;
	
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
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isStatus() 
	{
		return status;
	}
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	public String getShortDescription() 
	{
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) 
	{
		this.shortDescription = shortDescription;
	}
	
	
	
	
}
