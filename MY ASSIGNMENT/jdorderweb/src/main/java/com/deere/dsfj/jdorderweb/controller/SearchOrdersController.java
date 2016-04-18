package com.deere.dsfj.jdorderweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.Order;
import com.deere.dsfj.jdorder.form.OrderSearchForm;
import com.deere.dsfj.jdorder.service.CustomerService;
import com.deere.dsfj.jdorder.service.OrderService;

/** CustomerOrdersController class handles the request to display the Customer's Order */
@Controller
public class SearchOrdersController{

	/** logger object used to log the messages for this class */
	private final static Logger logger = LoggerFactory.getLogger(SearchOrdersController.class);

	/**Injecting orderService, this variable will be used to call OrderServiceImpl methods*/
    @Resource(name="orderService")
    private OrderService  orderService ;

	/** Injected customerService, this variable is used to call CustomerServiceImpl methods*/
    @Resource(name="customerService")
    private CustomerService  customerService ;


    @RequestMapping(value = {"/SearchOrders", "/SearchOrdersSecured"}, method=RequestMethod.GET)
    public String defaultSearchCustomers(Model model){
    	OrderSearchForm orderSearchForm =  new OrderSearchForm();
    	model.addAttribute("orderSearchForm",orderSearchForm);
        return "SearchOrders";
    }


    /**
     * viewOrdersForCustomer method is used to display the orders customer has placed. This method will call orderservice method to get the orderlist.
     *  Then it displays the orderlist on CustomersOrder screen
     * @param customerNumber of the customer
     * @param model
     * @param request
     * @return view name i.e CustomerOrders
     */

    @RequestMapping(value = {"/SearchOrders", "/SearchOrdersSecured"}, params="userAction=search" , method=RequestMethod.POST)
    public String viewOrdersForCustomer(@ModelAttribute("orderSearchForm") OrderSearchForm orderSearchForm,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        logger.debug("inside viewOrdersForCustomer");
    	//check if customerNumber is present. if customernumber is not present in url redirect to searchcustomers page with flasherror message

        Integer customerNumber = orderSearchForm.getCustomerNumber();
    	if(customerNumber == null){
    		//search customer screen
    		redirectAttributes.addFlashAttribute("flashError", "SearchOrders.InvalidEntry");
            return "redirect:SearchCustomers";
    	}

    	// check if customer is present in database.If customer not found, show flash message
    	Customer customer = customerService.getCustomer(customerNumber);
    	 if(customer == null){
    		 redirectAttributes.addFlashAttribute("flashError", "SearchOrders.InvalidCustomerNumber");
            return "redirect:SearchCustomers";
    	}

        // orderstatus code is blank, as we require all orders for a given customer
        String orderStatusCode = "";
//        OrderSearchForm orderSearchForm = new OrderSearchForm();
//        orderSearchForm.setCustomerNumber(customerNumber);
        orderSearchForm.setOrderStatusCode(orderStatusCode);
        List<Order> orderList = orderService.searchOrdersOfCustomer(orderSearchForm);
        model.addAttribute("customer", customer);
        model.addAttribute("orderList",orderList);
        return "SearchOrders";
    }

    // on click of create order  first post request to save customerId in session and then redirect to createOrder screen
}
