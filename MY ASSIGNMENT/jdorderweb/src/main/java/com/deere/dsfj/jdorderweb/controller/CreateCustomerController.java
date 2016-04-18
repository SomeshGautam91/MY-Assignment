package com.deere.dsfj.jdorderweb.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.State;
import com.deere.dsfj.jdorder.form.CustomerForm;
import com.deere.dsfj.jdorder.service.CustomerServiceImpl;
import com.deere.dsfj.jdorderweb.controller.helper.GeoPoliticalHelper;


@Controller
public class CreateCustomerController {

	/** Injecting geoPoliticalHelper,this variable will used to get the country and state information */
	@Autowired
    @Qualifier(value="geoPoliticalHelper")
    private GeoPoliticalHelper geoPoliticalHelper;
	
	@Autowired
	WebApplicationContext ctx;
	
	@Autowired
	private CustomerServiceImpl customerService;

	@RequestMapping("/CreateCustomer")
	public String displayCustomerView(Model model) {
		
		
		CustomerForm customerForm = new CustomerForm();
		System.out.println(customerForm.hashCode());
		String selectedCountryCode = "";
		String selectStateCode = "";
		
		customerForm.setCountryCode(selectedCountryCode);
        customerForm.setStateCode(selectStateCode);
		
		List<Country> countries = geoPoliticalHelper.getCountriesWithSelectText();
		List<State> states = geoPoliticalHelper.getStatesForCountryWithSelectText(selectedCountryCode);
		
		model.addAttribute("customerForm", customerForm);
		model.addAttribute("countries", countries);
		model.addAttribute("states",   states);

		return "CreateCustomer";
	}

	@RequestMapping(value = { "/CreateCustomer" }, method = RequestMethod.POST)
	public String createCustomer(@ModelAttribute("customerForm")CustomerForm customerForm,@RequestParam(value="image", required=false) MultipartFile image ,BindingResult bindingResult,HttpServletRequest request,Model model) {

		customerForm.validate(bindingResult);

		if(image != null && !(image.isEmpty())){
			System.out.println("con image set");
			customerForm.setPhoto(image);
		}
		Customer customer = customerService.add(customerForm, bindingResult);

		if(customer == null){
	            
			 	List<Country> countries = geoPoliticalHelper.getCountriesWithSelectText();
	            List<State> states = geoPoliticalHelper.getStatesForCountryWithSelectText(customerForm.getCountryCode());
	            
	            model.addAttribute("countries", countries);
	            model.addAttribute("states",   states);
	            model.addAttribute("customerForm", customerForm);
	            
	            return "CreateCustomer";  
	        }   
		return "redirect:ViewCustomer?customerNumber=" + customer.getNumber();
	}
}
