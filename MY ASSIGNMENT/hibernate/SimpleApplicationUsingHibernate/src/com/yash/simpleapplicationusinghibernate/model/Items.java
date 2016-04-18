package com.yash.simpleapplicationusinghibernate.model;


import javax.persistence.Embeddable;


@Embeddable
public class Items 
{
	
	private int itemId;
	private String name;
	
	public int getItemId() 
	{
		return itemId;
	}
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}
