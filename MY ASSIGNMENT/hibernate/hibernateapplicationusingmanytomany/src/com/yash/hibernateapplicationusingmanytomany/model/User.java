package com.yash.hibernateapplicationusingmanytomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;


@Entity
@Table(name="User_Table")
//@NamedNativeQuery(name = "User.byName", query = "SELECT * FROM User_Table WHERE user_name='Jack'", resultClass=User.class)
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="user_name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Project_Assignment" , joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="project_id")})
	
	private List<Projects> listOfProjects= new ArrayList<>();
	
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
	public void setListOfProjects(List<Projects> listOfProjects) 
	{
		this.listOfProjects = listOfProjects;
	}
	public List<Projects> getListOfProjects() 
	{
		return listOfProjects;
	}
	
}
