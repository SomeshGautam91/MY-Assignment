package com.yash.simpleapplicationusinghibernate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student 
{
	private int studentId;
	private String name;
	private Set<Book> books=new HashSet<Book>();
	private List<Certificates> certificates=new ArrayList<>();
	private Map<String,StudentAddress> studentAddress=new HashMap<>();
	
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
	public Set<Book> getBooks() 
	{
		return books;
	}
	public void setBooks(Set<Book> books) 
	{
		this.books = books;
	}
	public List<Certificates> getCertificates()
	{
		return certificates;
	}
	public void setCertificates(List<Certificates> certificates)
	{
		this.certificates = certificates;
	}
	public Map<String, StudentAddress> getStudentAddress()
	{
		return studentAddress;
	}
	public void setStudentAddress(Map<String, StudentAddress> studentAddress)
	{
		this.studentAddress = studentAddress;
	}
	
	
	
	
}
