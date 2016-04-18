package com.yash.CustomerCore.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.yash.CustomerCore.dao.CustomerDaoIfc;
import com.yash.CustomerCore.form.CustomerForm;
import com.yash.CustomerCore.model.Customer;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerServiceIfc {

	public CustomerServiceImpl() {
		System.out.println("service bean");
	}
	
	@Autowired
	CustomerDaoIfc customerDaoIfc;
	
	@Autowired
	DozerBeanMapper mapper;
	
	Customer customer=null;
	List<CustomerForm> customerFormList=null;
	public List<CustomerForm> saveCustomer(CustomerForm customerForm, Errors errors) {
		
		customer= new Customer();
		customerFormList=new ArrayList<CustomerForm>();
		
		if (errors.hasErrors()) {
			

			customerFormList = null;
		} 
		else 
		{
			//Mapper mapper= new DozerBeanMapper();
			mapper.map(customerForm, customer);
			System.out.println("name is ------"+customer.getName()+customer.getEmailId());
			List<Customer> customerList=customerDaoIfc.saveCustomer(customer);
			for(Customer obj:customerList)
			{
				customerFormList.add(mapper.map(obj,CustomerForm.class ));
			}
			
		
			
			
			/*customer.setName(customerForm.getName());
			customer.setEmailId(customerForm.getEmailId());
			List<Customer> customerList=customerDaoIfc.saveCustomer(customer);
			Iterator<Customer> customerItr=customerList.iterator();
			while(customerItr.hasNext())
			{
				Customer customer=customerItr.next();
				System.out.println("Name on service---- " +customer.getName()+" Email on service -----" + customer.getEmailId());
				CustomerForm newCustomerForm= new CustomerForm();
				newCustomerForm.setId(customer.getId());
				newCustomerForm.setName(customer.getName());
				newCustomerForm.setEmailId(customer.getEmailId());
				customerFormList.add(newCustomerForm);
				
			}*/
			
		}
		return customerFormList;

	}

}
