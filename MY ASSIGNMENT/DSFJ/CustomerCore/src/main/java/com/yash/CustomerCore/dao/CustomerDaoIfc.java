package com.yash.CustomerCore.dao;

import java.util.List;

import com.yash.CustomerCore.model.Customer;

public interface CustomerDaoIfc 
{
	public List<Customer> saveCustomer(Customer customer);
	
}
