package org.training.cdac.pojo;

public class Member {

	private int memberId;
	private String name;
	private String contactNo;
	private String typeOfMember;
	private int maxBooks; 
	
	public Member(int memberId, String name, String contactNo,
			String typeOfMember, int maxBooks) {
		this.memberId = memberId;
		this.name = name;
		this.contactNo = contactNo;
		this.typeOfMember = typeOfMember;
		this.maxBooks = maxBooks;
	}
	public void setMemberId(int memberId)
	{
		this.memberId=memberId;
		
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	public void setContactNo(String contactNo)
	{
		this.contactNo=contactNo;
		
	}
	public void setTypeOfMember(String typeOfMember)
	{
		this.typeOfMember=typeOfMember;
		
	}
	public void setMaxBooks(int maxBooks)
	{
		this.maxBooks=maxBooks;
		
	}
	public int getMemberId()
	{
		
		return memberId;
	}
	public String getName()
	{
		return name;
		
	}
	public String getContactNo()
	{
		return contactNo;
		
	}
	public String getTypeOfMember()
	{
		return typeOfMember;
		
	}
	public int getMaxBooks()
	{
		return maxBooks;
		
	}
}
