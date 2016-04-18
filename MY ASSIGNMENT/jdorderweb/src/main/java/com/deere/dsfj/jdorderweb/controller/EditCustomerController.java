package com.deere.dsfj.jdorderweb.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.FlashMap;

import com.deere.dsfj.jdorder.domain.Country;
import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.CustomerPhoto;
import com.deere.dsfj.jdorder.domain.State;
import com.deere.dsfj.jdorder.form.CustomerForm;
import com.deere.dsfj.jdorder.service.CustomerService;
import com.deere.dsfj.jdorderweb.controller.helper.GeoPoliticalHelper;

/** EditCustomerController class handles all the request for Edit Customer operation*/
@Controller
public class EditCustomerController{

	/** logger object used to log the messages for this class */
	private final static Logger logger = LoggerFactory.getLogger(EditCustomerController.class);
    
    
    /** Injecting geoPoliticalHelper,this variable will used to get the country and state information */
	@Autowired
    @Qualifier(value="geoPoliticalHelper")
    private GeoPoliticalHelper geoPoliticalHelper;
    
    
    /** dozerBeanMapping variable is used for mapping between CustomerBean and Customer */
	/*@Autowired
    @Qualifier(value="formDomainMapper")
    private DozerBeanMapper  dozerBeanMapping ;*/

	
	/** Injected customerService, this variable is used to call CustomerServiceImpl methods*/    
	@Resource(name="customerService")
    private CustomerService  customerService ;
    
    
	/**
	 * displayEditCustomer method will display the EditCustomer screen with Customer Details. This method will 
	 * call the customer service method to get the customer details.
	 * @param customerNumber of the customer to be edited
	 * @param request
	 * @param model
	 * @return view name i.e EditCustomer
	 */
   @RequestMapping(value = {"/EditCustomer"}, method=RequestMethod.GET)
    public String displayEditCustomer(@RequestParam(value="customerNumber", required=false) Integer customerNumber, Model model, HttpServletRequest request){
	   logger.debug("inside displayEditCustomer");
	   if(customerNumber == null){
        	//FlashMap.put("flashError", "EditCustomer.InvalidEntry");
            return "redirect:SearchCustomers";
        }
	   
	   // make call to service and get customer data
	   
        Customer customer = customerService.getCustomer(customerNumber);
        if(customer == null){
        	// not customer found in database. Hence redirect to search customer for selecting customer
        	//FlashMap.put("flashError", "EditCustomer.InvalidEntry");
            return "redirect:SearchCustomers";
        }
        
       // CustomerForm customerForm = dozerBeanMapping.map(customer, CustomerForm.class);
        CustomerForm  customerForm = new CustomerForm();
        
        String countryCode = "";
        
        if(customerForm != null){
            countryCode = customerForm.getCountryCode();
        }
        List<Country> countries = geoPoliticalHelper.getCountriesWithSelectText();
        List<State> states = geoPoliticalHelper.getStatesForCountryWithSelectText(countryCode);
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        model.addAttribute("customerForm", customerForm);
        if(customer != null && customer.getPhoto() != null){
        	String photoPathOnServer = customer.getPhoto().getFilePathOnServer();
        	model.addAttribute("photoPathOnServer", photoPathOnServer);
        }
        return "EditCustomer";
    }
   
    
   /**
    * saveCustomer method will handle the save customer request.This method will pass the customer object to customer service.
    * Once the customer is updated in database this method will redirect to ViewCustomerController to display the customer details. 
    * @param customerBean will contain all the values user has entered on EditCustomer screen
    * @param bindingResult will contain the Error messages if any to be displayed on the screen
    * @param image will contain Multipart image file of the customer photo
    * @param model
    * @param request
    * @return 
    */
 /*  @RequestMapping(value = {"/EditCustomer"},  params="userAction=save",method=RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customerForm")CustomerForm customerForm, BindingResult bindingResult, 
                               @RequestParam(value="image", required=false) MultipartFile image, 
                               @RequestParam(value="photoPathOnServer", required=false) String photoPathOnServer, Model model){
	   logger.debug("inside saveCustomer");
       if(image != null && !(image.isEmpty())){
       	customerForm.setPhoto(image);
       }
	   customerForm.validate(bindingResult);
	   Customer customer = customerService.update(customerForm, bindingResult);
       // failure
       if(customer == null){
		   List<Country> countries = geoPoliticalHelper.getCountriesWithSelectText();
           List<State> states = geoPoliticalHelper.getStatesForCountryWithSelectText(customerForm.getCountryCode());

            // re-displaying of photo incase of error
           if(photoPathOnServer != null){
           	model.addAttribute("photoPathOnServer", photoPathOnServer);
           }
           model.addAttribute("countries", countries);
           model.addAttribute("states",   states);
           model.addAttribute("customerForm", customerForm);
           return "EditCustomer";
        }
        // success
        return "redirect:ViewCustomer?customerNumber=" + customer.getNumber();
    }
    
   *//**
    * cancel method will discard all the changes on screen and will display SearchCustomer screen
    * @param model
    * @return
    *//*
    @RequestMapping(value = {"/EditCustomer"}, params="userAction=cancel", method=RequestMethod.POST)
    public String cancel(Model model){
        logger.debug("inside cancel");
        return "redirect:SearchCustomers";
    }
    
    
    // this is going to be called from two screen. Hence to simplfy things go to search screen
    @RequestMapping(value = {"/EditCustomer"}, params="userAction=delete", method=RequestMethod.POST)
    public String delete(@ModelAttribute("customerForm")CustomerForm customerForm, Model model){
        // TODO
        
        // make call to service 
        // delete user and show success message on which screen. Check how this have been done
        // if error how to show error message 
        logger.debug("inside delete");
        return "redirect:SearchCustomers";
    }
    
    *//**
     * displayImageFile is used to display customer photo on View Customer screen.
     * This method is called when ViewCustomer screen is being rendered 
     * i.e <spring:url var="customerPhotoUrl" value="/web/EditCustomer?pathOnServer={path}" > will make a call to this method.
     * This method will pass the pathOnServer variable to customerService method.
     * Customer Service method will pass the populated Customer Photo object back to this method.
     * @param pathOnServer variable holds the path on the server where photo is stored
     * @param response
     */
    @RequestMapping(value = {"/EditCustomer"}, method=RequestMethod.GET, params="pathOnServer")
    public void displayImageFile(@RequestParam(value="pathOnServer", required=true) String pathOnServer, HttpServletResponse response){
 	    logger.debug("inside displayImageFile");
        CustomerPhoto customerPhoto = customerService.getCustomerPhoto(pathOnServer);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = customerPhoto.getInputStream();
            outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
        }catch(Exception ex){}
        finally{
            if(inputStream != null){
                IOUtils.closeQuietly(inputStream);
            }
            
            if(outputStream != null){
                IOUtils.closeQuietly(outputStream);
            }
        }
    }
}
