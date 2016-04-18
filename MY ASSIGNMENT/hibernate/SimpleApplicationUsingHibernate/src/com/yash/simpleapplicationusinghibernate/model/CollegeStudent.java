package com.yash.simpleapplicationusinghibernate.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="College_Student")
public class CollegeStudent 
{
	
	@Id
	@Column(name="student_id")
	private int studentId;
	@Column(name="name")
	private String name;
	@Column(name="college_id")
	private int collegeId;
	
	public int getStudentId() 
	{
		return studentId;
	}
	public void setStudentId(int studentId) 
	{
		this.studentId = studentId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	/*public int getCollegeId() 
	{
		return collegeId;
	}
	public void setCollegeId(int collegeId)
	{
		this.collegeId = collegeId;
	}*/
	
	
	
	
	
}
