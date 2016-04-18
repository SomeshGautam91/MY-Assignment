package com.yash.hibernateapplicationusingmanytomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Projects_Table")
public class Projects 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int projectId;
	
	@Column(name="project_name")
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="listOfProjects")
	private List<User> listOfUsers= new ArrayList<>();
	
	public int getProjectId()
	{
		return projectId;
	}
	public void setProjectId(int projectId) 
	{
		this.projectId = projectId;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setListOfUsers(List<User> listOfUsers)
	{
		this.listOfUsers = listOfUsers;
	}
	public List<User> getListOfUsers() 
	{
		return listOfUsers;
	}
	
}
