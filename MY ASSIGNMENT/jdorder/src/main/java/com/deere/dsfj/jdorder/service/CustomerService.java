package com.deere.dsfj.jdorder.service;

import java.util.List;

import org.springframework.validation.Errors;

import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.CustomerPhoto;
import com.deere.dsfj.jdorder.form.CustomerForm;
import com.deere.dsfj.jdorder.form.CustomerSearchForm;
/** This is an interface for CustomerServiceImpl*/

public interface CustomerService{
	
	
    public Customer getCustomer(Integer customerNumber);
    public Customer add(CustomerForm customerForm, Errors errors);
    public List<Customer> searchCustomers(CustomerSearchForm searchCriteria);
   // public List<Customer> listOfCustomers();
    public CustomerPhoto getCustomerPhoto(String pathOnServer);
    

}
