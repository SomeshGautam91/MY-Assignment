package com.yash.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.pojo.Contact;
import com.yash.training.service.UserService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger =LoggerFactory.getLogger(ContactController.class);
	
	@RequestMapping("/showContact.htm")
	public ModelAndView showForm()
	{
		logger.info("showForm Start");
		ModelAndView modelAndView = new ModelAndView("contact");
		logger.info("showForm end");
		return modelAndView;
		
	}
	@RequestMapping("/submitContact.htm")
	public ModelAndView submitForm(@ModelAttribute("contact") Contact contact,HttpSession session)
	{
		logger.info("submitForm Start");
		List<Contact> contactList=userService.addContact(contact,session);
		ModelAndView modelAndView= new ModelAndView("displayList");
		modelAndView.addObject("username",session.getAttribute("USERNAME"));
		modelAndView.addObject("contacts",contactList);
		logger.info("submitForm end");
		return modelAndView;
		
	}
	
	@RequestMapping("/contacts.htm")
	public ModelAndView submitList(HttpServletRequest request )
	{
		logger.info("submitList Start");
		HttpSession session=request.getSession();
		List<Contact> contactList=userService.getContact(session);
		ModelAndView modelAndView= new ModelAndView("displayList");
		modelAndView.addObject("username",session.getAttribute("USERNAME"));
		modelAndView.addObject("contacts",contactList);
		logger.info("submitList end");
		return modelAndView;
		
	}
	@RequestMapping("/userWelcome.htm")
	public ModelAndView userView()
	{
		logger.info("userView Start");
		ModelAndView modelAndView= new ModelAndView("userwelcome");
		logger.info("userView end");
		return modelAndView;
		
	}
	@RequestMapping("/deleteContact.htm")
	public ModelAndView deleteContact(@RequestParam("uid")String uid,HttpSession session)
	{
		logger.info("deleteContact Start");
		List<Contact> contactList=userService.deleteContact(uid, session);
		ModelAndView modelAndView= new ModelAndView("displayList");
		modelAndView.addObject("username",session.getAttribute("USERNAME"));
		modelAndView.addObject("contacts",contactList);
		logger.info("deleteContact end");
		return modelAndView;
		
	}
	@RequestMapping("/searchContact.htm")
	public ModelAndView searchContact(@RequestParam("textsearch") String input,HttpSession session)
	{
		List<Contact> contactList=userService.searchContact(input,session);
		ModelAndView modelAndView= new ModelAndView("displayList");
		modelAndView.addObject("username",session.getAttribute("USERNAME"));
		modelAndView.addObject("contacts",contactList);
		return modelAndView;
		
	}
	
	@RequestMapping("/updateContact1.htm")
	public ModelAndView updateContact(@RequestParam("uid")String id,@RequestParam("uname")String name,@RequestParam("ucontact") String ucontact,@RequestParam("uemail")String email,@RequestParam("uaddress")String address,HttpSession session)
	{
		session.setAttribute("uname",name);
		session.setAttribute("uid",id);
		int newId=Integer.parseInt(id);
		ModelAndView modelAndView= new ModelAndView("updateContact");
		Contact contact=new Contact();
		contact.setId(newId);
		contact.setName(name);
		long fetchContact=Long.parseLong(ucontact);
		contact.setContact(fetchContact);
		contact.setEmail(email);
		contact.setAddress(address);
		modelAndView.addObject("contact",contact);
		return modelAndView;
		
	}
	@RequestMapping("/updateContact.htm")
	public ModelAndView updateContact(@ModelAttribute("contact") Contact contact,HttpSession session)
	{
		System.out.println(session.getAttribute("uid"));
		List<Contact> contactList=userService.updateContact(contact, session);
		ModelAndView modelAndView= new ModelAndView("displayList");
		modelAndView.addObject("username",session.getAttribute("USERNAME"));
		modelAndView.addObject("contacts",contactList);
		return modelAndView;
		
		
	}

}
