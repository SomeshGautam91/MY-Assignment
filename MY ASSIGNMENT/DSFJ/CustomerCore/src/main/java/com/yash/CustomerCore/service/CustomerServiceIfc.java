package com.yash.CustomerCore.service;

import java.util.List;

import org.springframework.validation.Errors;

import com.yash.CustomerCore.form.CustomerForm;

public interface CustomerServiceIfc {
	public List<CustomerForm> saveCustomer(CustomerForm customerFrom,
			Errors error);
}
