package com.yash.CustomerWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yash.CustomerCore.form.CustomerForm;
import com.yash.CustomerCore.model.Customer;
import com.yash.CustomerCore.service.CustomerServiceIfc;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {
	@Autowired
	CustomerServiceIfc customerServiceIfc;

	@RequestMapping(value = "/customerregistrationpage", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {

		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		return "User";
	}

	@RequestMapping(value = "/customerregistration", method = RequestMethod.POST)
	public String getRegistration(@ModelAttribute("customerForm") CustomerForm customerForm,BindingResult bindingResult) {
		customerForm.validation(bindingResult);
		CustomerForm returnCustomerForm = customerServiceIfc.saveCustomer(customerForm, bindingResult);
		
		if (returnCustomerForm == null) {
			return "Registration";
		} else {
			return "Success";
		}

	}
}
