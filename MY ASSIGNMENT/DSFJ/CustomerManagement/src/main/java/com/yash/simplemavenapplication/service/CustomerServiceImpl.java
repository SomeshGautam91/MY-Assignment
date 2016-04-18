package com.yash.simplemavenapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.simplemavenapplication.dao.CustomerDaoIfc;
import com.yash.simplemavenapplication.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerServiceIfc {

	@Autowired 
	CustomerDaoIfc customerDao;
	@Override
	public void saveCustomer(Customer customer)
	{
		
		customerDao.saveCustomer(customer);
	}

}
