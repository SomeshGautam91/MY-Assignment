package com.yash.simplemavenapplication.dao;

import org.springframework.stereotype.Repository;

import com.yash.simplemavenapplication.model.Customer;


public interface CustomerDaoIfc 
{
	public void saveCustomer(Customer customer);
}
