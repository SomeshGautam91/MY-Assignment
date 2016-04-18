package com.deere.dsfj.jdorderweb.controller;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.CustomerPhoto;
import com.deere.dsfj.jdorder.service.CustomerService;

/**
 * ViewCustomerController class is handles all the request to display the View
 * Customer screen
 */
@Controller
public class ViewCustomerController {

	/** logger object used to log the messages for this class */
	private final static Logger logger = LoggerFactory.getLogger(CreateCustomerController.class);

	/**
	 * Injecting proxy of customerContainerSessionBean,this variable will
	 * contain the customer session data
	 */
	@Resource(name = "customerService")
	private CustomerService customerService;

	
	@Autowired
	private ServletContext context;
	/**
	 * displayViewCustomer method is used to display the View Customer screen
	 * with customer details
	 */

	@RequestMapping(value = { "/ViewCustomer" }, method = RequestMethod.GET, params = "customerNumber")
	public String displayViewCustomer(@RequestParam(value = "customerNumber", required = false) Integer customerNumber,	Model model, HttpServletRequest request) {
		logger.debug("inside displayViewCustomer");
		if (customerNumber == null) {
			// FlashMap.put("flashError", "ViewCustomer.InvalidEntry");
			return "redirect:SearchCustomers";
		}
		Customer customer = customerService.getCustomer(customerNumber);

		if (customer == null) {
			// FlashMap.put("flashError", "ViewCustomer.InvalidCustomerNumber");
			return "redirect:SearchCustomers";
		}
		model.addAttribute("customer", customer);
		return "ViewCustomer";
	}

	/**
	 * displayImageFile is used to display customer photo on View Customer
	 * screen. This method is called when ViewCustomer screen is being rendered
	 * i.e <spring:url var="customerPhotoUrl" value=
	 * "/web/ViewCustomer?pathOnServer={path}" > will make a call to this
	 * method. This method will pass the pathOnServer variable to
	 * customerService method. Customer Service method will pass the populated
	 * Customer Photo object back to this method.
	 * 
	 * @param pathOnServer
	 *            variable holds the path on the server where photo is stored
	 * @param response
	 */
	
	/*@RequestMapping(value = { "/ViewCustomer/Photo" }, method = RequestMethod.GET, params = "customerNumber")
	public void displayImageFile(@RequestParam(value = "customerNumber", required = true) Integer customerNumber,
			HttpServletResponse response) {
		logger.debug("inside displayImageFile");
		// create
		String filePath = null;
		CustomerPhoto customerPhoto = customerService.getCustomerPhoto(customerNumber);
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {

			if (customerPhoto != null && customerPhoto.getInputStream() != null) {
				filePath = customerPhoto.getFilePathOnServer();
				File file = new File(filePath);

				inputStream = FileUtils.openInputStream(file);
			} else {
				inputStream = context.getResourceAsStream("/images/PhotoNotAvailable.jpg");
			}
			response.setContentType("image/jpeg");
			outputStream = response.getOutputStream();
			IOUtils.copy(inputStream, outputStream);
		} catch (Exception ex) {
			System.out.println("exception while reading file");
		} finally {
			if (inputStream != null) {
				IOUtils.closeQuietly(inputStream);
			}

			if (outputStream != null) {
				IOUtils.closeQuietly(outputStream);
			}
		}
	}*/
}
