package com.deere.dsfj.jdorder.doa.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.CustomerDao;
import com.deere.dsfj.jdorder.domain.Customer;

/**
 * 
 * @author dinesh.kumar
 *
 */
@Repository(value="customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer findById(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	


}
