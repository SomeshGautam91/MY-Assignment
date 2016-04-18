package com.yash.simplemavenapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yash.simplemavenapplication.model.Customer;
import com.yash.simplemavenapplication.service.CustomerServiceIfc;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {
	@Autowired
	CustomerServiceIfc customerServiceIfc;

	@RequestMapping(value = "/customerregistrationpage", method = RequestMethod.GET)
	public String getRegistrationPage(Model model)
	{

		Customer customerForm = new Customer();
		model.addAttribute("customerForm", customerForm);
		return "Registration";
	}

	@RequestMapping(value = "/customerregistration", method = RequestMethod.POST)
	public String getRegistration(@ModelAttribute("customer") Customer customer) {
		customerServiceIfc.saveCustomer(customer);
		return "Success";

	}
}
