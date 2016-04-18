package com.yash.CustomerWeb.controller;

import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yash.CustomerCore.form.CustomerForm;
import com.yash.CustomerCore.service.CustomerServiceIfc;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	
	CustomerServiceIfc customerServiceIfc;

	@RequestMapping(value = "/customerregistrationpage")
	public String getRegistrationPage(Model model) {

		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		return "Registration";
	}

	@RequestMapping(value = "/customerregistration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getRegistration(@ModelAttribute("customerForm") CustomerForm customerForm,BindingResult bindingResult) {

		System.out.println("name " + customerForm.getName());

		customerForm.validation(bindingResult);

		List<CustomerForm> returnCustomerForm = customerServiceIfc
				.saveCustomer(customerForm, bindingResult);

		System.out.println("return list is  " + returnCustomerForm.size());
		Iterator<CustomerForm> itr = returnCustomerForm.iterator();
		
		while (itr.hasNext())
		{
			CustomerForm customerForm1 = itr.next();
			System.out.println(customerForm1.getName() + customerForm1.getEmailId());
		}

		Gson gson = new Gson();
		return gson.toJson(returnCustomerForm);

	}

}
