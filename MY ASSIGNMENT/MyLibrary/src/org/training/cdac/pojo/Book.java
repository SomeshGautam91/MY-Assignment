package org.training.cdac.pojo;


import java.util.ArrayList;
import java.util.Date;


public class Book {

	private String title;
	private String author;
	private int quantity;
	private int id;
	private int memberId;
	private String issueDate;
	private String returnDate;


	public Book(int id,String title,String author,int quantity,int memberId)
	{
		this.id=id;
		this.title=title;
		this.author=author;
		this.quantity=quantity;
		this.memberId=memberId;
		
	}

	public Book(int id,String title,String author, int quantity) {

		this.title = title;
		this.author = author;
		this.quantity = quantity;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title)
	{
		this.title=title;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	
	
	
}
