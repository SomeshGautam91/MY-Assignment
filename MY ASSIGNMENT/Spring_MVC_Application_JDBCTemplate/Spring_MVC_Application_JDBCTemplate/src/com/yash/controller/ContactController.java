package com.yash.controller;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.logger.Log;
import com.yash.model.Contact;
import com.yash.model.User;
import com.yash.service.UserServiceInf;
import com.yash.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("Contact")
public class ContactController {
	
	 @Autowired
     private UserServiceInf userServiceInf;
	 
	 
	 @RequestMapping("/Save.do")
	    public ModelAndView Save(@Valid @ModelAttribute("contact") Contact contact,BindingResult result,HttpServletRequest request) throws SQLException, ClassNotFoundException  {
		    
		   
			if(result.hasErrors())
			{  
				 ModelAndView model=new ModelAndView("ContactAdd");
				 return model;
			}
			HttpSession session=request.getSession();
			User u=(User)session.getAttribute("user");
			userServiceInf.addContact(contact,u.getUsername());
			contact.setName(null);
			contact.setContact_id(0);
            List<Contact> list= userServiceInf.ContactRetrive(contact,u.getUsername());
	 	    ModelAndView model=new ModelAndView("Welcome");
	 	    model.addObject("user1",u);
	 	    model.addObject("list",list);


	 	      
	           return model;
	 	}
	 
	 @RequestMapping("/AddContact.do")
	    public ModelAndView Add(@Valid @ModelAttribute("contact") Contact contact,BindingResult result) throws SQLException, ClassNotFoundException  {
		       
               ModelAndView model=new ModelAndView("ContactAdd");
             
	           return model;
	 	}
	 
	 @RequestMapping("/View.do")
	    public ModelAndView Retrive(@ModelAttribute("contact") Contact contact,HttpServletRequest request) throws SQLException, ClassNotFoundException  {
		      
		       Log.getlog().info("Retrive Contact List Method Call");
		       HttpSession session=request.getSession();
		       User u=(User)session.getAttribute("user");
               List<Contact> list= userServiceInf.ContactRetrive(contact,u.getUsername());
	 	       ModelAndView model=new ModelAndView("Welcome");
	 	       model.addObject("list",list);
	 	       model.addObject("user1",u);
	 	      Log.getlog().info("Retrive Contact List Method Call End");
	           return model;
	 	}
	 
	 @RequestMapping("/Delete.do")
	    public ModelAndView Delete(@ModelAttribute("contact") Contact contact,HttpServletRequest request ) throws SQLException, ClassNotFoundException  {
			
		       // System.out.println("in delete "+contact.getName());
			   // contact.setName(request.getParameter("name"));
			    HttpSession session=request.getSession();
			    User u=(User)session.getAttribute("user");
			   
			    ModelAndView model=new ModelAndView("Welcome");
			   if(userServiceInf.removeContact(contact.getContact_id()))
			   {
				   
				   contact.setName(null);
				   model.addObject("list", userServiceInf.ContactRetrive(contact,u.getUsername()));
		 	       model.addObject("user1",u);
		 	       return model;
			   }
			   
			   model.addObject("list", userServiceInf.ContactRetrive(contact,u.getUsername()));
			   contact.setName(null);
	 	       model.addObject("user1",u);
	 	       return model;
			 
	 	}
	 
	 @RequestMapping("/Edit.do")
	    public ModelAndView Edit(@ModelAttribute("contact") Contact contact,HttpServletRequest request) throws SQLException, ClassNotFoundException  {
			
			
		       //contact.setName(request.getParameter("name"));
		        HttpSession session=request.getSession();
	            User u=(User)session.getAttribute("user");
	           // System.out.println("in edit"+contact.getContact_id());
	             session.setAttribute("id", contact.getContact_id());
	             System.out.println("name"+contact.getName());
			    List<Contact> list=userServiceInf.ContactRetrivebyid(contact, u.getUsername());
	 	        ModelAndView model=new ModelAndView("ContactEdit");
	 	        model.addObject("list",list);
	            return model;
	 	}
	 
	 @RequestMapping("/EditOne.do")
	    public ModelAndView EditOne(@ModelAttribute("contact") Contact contact,HttpServletRequest request) throws SQLException, ClassNotFoundException  {
		   
		 
		     ModelAndView model=new ModelAndView("Welcome");
		     HttpSession session=request.getSession();
		     User u=(User)session.getAttribute("user");
		     contact.setContact_id((Integer)session.getAttribute("id"));
		     System.out.println(contact.getName());
		    if(userServiceInf.editContact(contact))
		   {
		       System.out.println("edit");
		       contact.setName(null);
	 	       model.addObject("list", userServiceInf.ContactRetrive(contact,u.getUsername()));
	 	       model.addObject("user1",u);
	 	       return model;
		   }
		      
		       contact.setName(null);
		       model.addObject("list", userServiceInf.ContactRetrive(contact,u.getUsername()));
			   model.addObject("user1",u);
	 	       return model;
			  
	 	}
	
	

}
