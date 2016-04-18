package com.deere.dsfj.jdorder.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.deere.dsfj.jdorder.dao.CustomerDao;
import com.deere.dsfj.jdorder.dao.CustomerPhotoDao;
import com.deere.dsfj.jdorder.dao.StateDao;
import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.CustomerPhoto;
import com.deere.dsfj.jdorder.domain.State;
import com.deere.dsfj.jdorder.form.CustomerForm;
import com.deere.dsfj.jdorder.form.CustomerSearchForm;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	/**
	 * Injected customerDao, this variable is used to call customarDaoImpl
	 * methods
	 */

	
	@Resource(name = "customerDao")
	private CustomerDao customerDao;
	
	@Resource
	private StateDao stateDao;

	/**
	 * Injected customerPhotoDao, this variable is used to call
	 * customerPhotoDaoImpl methods
	 */
	@Resource(name = "customerPhotoDao")
	private CustomerPhotoDao customerPhotoDao = null;

	public CustomerServiceImpl() {
		System.out.println(this + "This is from service layer");
	}

	@Override
	public Customer getCustomer(Integer customerNumber) {
		Customer customer = customerDao.findById(customerNumber);
		if(customer != null){
            assignStateToCustomer(customer);
        }
 	    return customer;
	}

	@Override
	public Customer add(CustomerForm customerForm, Errors errors) {

		// validate my form..
		//apply my all bussiness use case..
		
		
		Customer customer = new Customer();
		CustomerPhoto customerPhoto = new CustomerPhoto();
		State state = new State();

		customer.setAddress(customerForm.getAddress());
		customer.setCity(customerForm.getCity());
		customer.setName(customerForm.getName());
		customer.setZip(customerForm.getZip());
		state.setCode(customerForm.getStateCode());
		customer.setState(state);
		customerPhoto.setOriginalFileName(customerForm.getPhoto().getOriginalFilename());

		customer.setPhoto(customerPhoto);

		try {
			customerPhoto.setInputStream(customerForm.getPhoto().getInputStream());
		} catch (IOException e) {
			System.out.println("Image had issues");
			e.printStackTrace();
		}

		if (errors.hasErrors()) {
			// validation error
			customer = null;
		} else {
			customerDao.add(customer);
			if (customer.getPhoto() != null) {
				System.out.println("going to save file");
				customerPhotoDao.add(customer.getPhoto());
			}
		}
		return customer;
	}

	@Override
	public List<Customer> searchCustomers(CustomerSearchForm searchCriteria) {
		// logger.debug("inside CustomerServiceImpl SearchCustomers start");
		List<Customer> customerList = null;
		if (searchCriteria.getNumber() > 0) {
			Customer customer = customerDao.findById(searchCriteria.getNumber());
			if (customer != null) {
				customerList = new ArrayList<Customer>();
				customerList.add(customer);
			}
		} else {
			customerList = customerDao.findByName(searchCriteria.getName());
		}
		//assignStateToCustomerList(customerList);
		// logger.debug("inside CustomerServiceImpl SearchCustomers end");

		return customerList;
	}

	/** getCustomerPhoto method is used to return the CustomerPhoto object */
	@Override
	public CustomerPhoto getCustomerPhoto(String pathOnServer) {
		return customerPhotoDao.getCustomerPhoto(pathOnServer);
	}
	
	private void assignStateToCustomer(Customer customer){
        String stateCode = customer.getState().getCode();
        State state = stateDao.findByCode(stateCode);
        customer.setState(state);
    }
}
