package com.yash.simpleapplicationusinghibernate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Restaurant
{
	@Id
	@GeneratedValue
	private int regnNo;
	private String name;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="Restaurant_id")
	
	@ElementCollection
	private List<Items> items=new ArrayList<>();;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Restaurant_id")
	private Set<Labour> labours;
	
	public int getRegnNo()
	{
		return regnNo;
	}
	public void setRegnNo(int regnNo)
	{
		this.regnNo = regnNo;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public List<Items> getItems() 
	{
		return items;
	}
	public void setItems(List<Items> items) 
	{
		this.items = items;
	}
	
	public Set<Labour> getLabours() {
		return labours;
	}
	public void setLabours(Set<Labour> labours) {
		this.labours = labours;
	}
	
	
	
}
