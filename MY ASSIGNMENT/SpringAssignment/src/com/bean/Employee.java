package com.bean;

public class Employee {
	
	private int id;
	private String name;
	private Address address;
	
	

    private Employee()
	{
		System.out.println("Constructor Called");
	}
	
//    public Employee(int id, String name, Address address) 
//	{
//		this.id = id;
//		this.name = name;
//		this.address = address;
//	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void display()
	{
		System.out.println("Hello "+ name);
		System.out.println("Your Id "+ id);
		//System.out.println("Your Address "+address.getHouseNo()+" "+address.getStreet()+" "+address.getCity());
	}

	
		
}
