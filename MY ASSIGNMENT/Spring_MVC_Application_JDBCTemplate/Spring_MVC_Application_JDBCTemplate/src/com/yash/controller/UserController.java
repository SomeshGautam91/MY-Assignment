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
import com.yash.utility.ConnectionProvider;

@Controller
@RequestMapping("User")
public class UserController
{
	 @Autowired
     private UserServiceInf serviceInf;
	
     
	
	@RequestMapping("/Add.do")
    public ModelAndView Add(@Valid @ModelAttribute("user") User user,BindingResult result) throws SQLException, ClassNotFoundException  {
		Log.getlog().info("User Save Method Call");
		if(result.hasErrors())
		{
			 ModelAndView model=new ModelAndView("Rgistration");
			 Log.getlog().info("User Save Method Call End");
			 return model;
		}
		 
		   serviceInf.addUser(user);
 	       ModelAndView model=new ModelAndView("Home");
 	       
 	       Log.getlog().info("User Save Method Call End");
           return model;
 	}
	

	
	@RequestMapping("/Login.do")
    public ModelAndView Login()
    {    
		Log.getlog().info("Login Page Display Method Call");
//		if(maintanance())
//		{
//			ModelAndView model=new ModelAndView("Maintanance");	
//			return model;
//		}
    	ModelAndView model=new ModelAndView("Login");
    	Log.getlog().info("Login Page Display Method Call End");
    	return model;
    }
	
	@RequestMapping("/Check.do")
    public ModelAndView LoginOne(@Valid @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request) throws SQLException, ClassNotFoundException
    {   
		
		 User user1=serviceInf.Checklogin(user);
		if(user1.getName()!=null)
		{    
			HttpSession session=request.getSession();
			session.setAttribute("user",user1);
		    List<Contact> list= serviceInf.ContactRetrive(new Contact(),user1.getUsername());
	 	    ModelAndView model=new ModelAndView("AfterLoginJqueryPage");
	 	   /* model.addObject("list",list);
	 	    model.addObject("user1",user1);*/
	 	    Log.getlog().info("Login Check Method Call end"); 
			return model;
		}
		ModelAndView model=new ModelAndView("Login","msg","Please Enter Correct Details");
		Log.getlog().info("Login Check Method Call End");    
    	return model;
    }
	
	@RequestMapping("/Registration.do")
    public ModelAndView Regi()
	{
		Log.getlog().info("Registration Page Dispaly Method Call");
//		if(maintanance())
//		{
//			ModelAndView model=new ModelAndView("Maintanance");	
//			return model;
//		}
    	ModelAndView model=new ModelAndView("Rgistration");
    	Log.getlog().info("Registration Page Dispaly Method Call End");
    	return model;
    }
	
	@RequestMapping("/Home.do")
    public ModelAndView Home()
    {
		//System.out.println(maintanance());
		
		Log.getlog().info("Home Page Dispaly Method Call");
    	ModelAndView model=new ModelAndView("Home");
    	
    	Log.getlog().info("Home Page Dispaly Method Call End");
    	return model;
    }



	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.serviceInf = userServiceImpl;
	}



	
	


	
	


}


