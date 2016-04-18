package com.yash.simpleapplicationusinghibernate.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;

@Entity
public class College 
{
	@Id
	@Column(name="college_id")
	private int collegeId;
	
	@Column(name="college_Name")
	private String collegeName;
	
	@ElementCollection
	@CollectionTable(name="collegestudent",joinColumns=@JoinColumn(name="college_id"))
	private Set<CollegeStudent> students=new HashSet<>();
	
	public int getCollegeId() 
	{
		return collegeId;
	}
	public void setCollegeId(int collegeId) 
	{
		this.collegeId = collegeId;
	}
	public String getCollegeName() 
	{
		return collegeName;
	}
	public void setCollegeName(String collegeName) 
	{
		this.collegeName = collegeName;
	}
	public Set<CollegeStudent> getStudents() 
	{
		return students;
	}
	public void setStudents(Set<CollegeStudent> students) 
	{
		this.students = students;
	}
	
	
	
	
}
