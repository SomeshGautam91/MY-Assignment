package com.deere.dsfj.jdorderweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.form.CustomerSearchForm;
import com.deere.dsfj.jdorder.service.CustomerService;
import com.deere.dsfj.jdorderweb.session.CustomerContainerSession;

/**
 * The SearchCustomerController class will handle all the requests related to
 * Customer Search operations.
 */

@Controller
public class SearchCustomersController {


	@Autowired
	WebApplicationContext webCTX;
	
	
	 /** Injecting proxy of customerContainerSessionBean,this variable will contain the customer session data */
    @Autowired
    @Qualifier(value="customerContainerSessionBean")
    private CustomerContainerSession customerContainerSessionBean;
	
    
    
	@Resource(name="customerService")
	private CustomerService customerService;
	
	/** displaySearchCustomer method will display blank SearchCustomer screen */
	@RequestMapping(value = "/SearchCustomers" , method = RequestMethod.GET)
	public String defaultSearchCustomers(Model model) {
		CustomerSearchForm searchCriteria = customerContainerSessionBean.getSearchCriteria();
		System.out.println("GET BEAN " + webCTX.getBean("customerService"));
		
		List<Customer> customerList = null;
        
		if(searchCriteria == null){
        	searchCriteria = new CustomerSearchForm();
        	customerList = new ArrayList<Customer>();
        }
		/*CustomerSearchForm searchCriteria = new CustomerSearchForm();*/
		model.addAttribute("searchCriteria", searchCriteria);
		return "SearchCustomers";
	}
		
	@RequestMapping(value = {"/SearchCustomers"}, params="userAction=search" , method=RequestMethod.POST)
	public String search(@ModelAttribute("searchCriteria") CustomerSearchForm searchCriteria,BindingResult bindingResult, Model model){
		
		customerContainerSessionBean.setSearchCriteria(searchCriteria);
		System.out.println("GET POST  =" + customerContainerSessionBean.getSearchCriteria().getName());
		
		searchCriteria.checkAndAssignValues();
		List<Customer> customerList =customerService.searchCustomers(searchCriteria);
		
		 if (customerList == null || customerList.isEmpty()){  
	        	bindingResult.reject("SearchCustomer.noResultFound");
	     }
		 model.addAttribute("searchCriteria", searchCriteria);
	     model.addAttribute("customerList", customerList);
		return "SearchCustomers";
	}

}
