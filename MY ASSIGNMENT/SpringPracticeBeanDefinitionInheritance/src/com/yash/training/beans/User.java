package com.yash.training.beans;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class User implements InitializingBean,DisposableBean
{
	private String name;
	private Address permAddress;
	private Address comAddress;
	
	
	public Address getComAddress() {
		return comAddress;
	}
	public void setComAddress(Address comAddress) {
		this.comAddress = comAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(Address permAddress) {
		this.permAddress = permAddress;
	}
	public void show() {
		System.out.println("name "+ getName());
		System.out.println("----------Permanent Address------------------");
		System.out.println("houseNo "+ getPermAddress().getHouseNo());
		System.out.println("street "+ getPermAddress().getStreet());
		System.out.println("city "+ getPermAddress().getCity());
		System.out.println("----------Company Address------------------");
		System.out.println("houseNo "+ getComAddress().getHouseNo());
		System.out.println("street "+ getComAddress().getStreet());
		System.out.println("city "+ getComAddress().getCity());
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Container Destroy method is called");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Container Initialization method is called");
		
	}
	
	public void myInit()
	{
		System.out.println("MY INIT() is called");
	}
	
	public void myDestroy()
	{
		System.out.println("MY DESTROY() is called");
	}
	
	
}
