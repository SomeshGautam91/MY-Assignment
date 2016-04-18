package com.deere.dsfj.jdorder.dao;

import java.util.List;

import com.deere.dsfj.jdorder.domain.Customer;

/**
 * 
 * @author dinesh.kumar
 *
 */
public interface CustomerDao {

	public void add(Customer customer);
	public Customer findById(Integer customerId);
	
	public List<Customer> findByName(String name);
	//public void add();
}
