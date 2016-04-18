package com.yash.training.controller;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.pojo.Contact;
import com.yash.training.pojo.User;
import com.yash.training.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	private static final Logger logger =LoggerFactory.getLogger(UserController.class);
	
	public void setUserService(UserService userService) 
	{
		logger.info("setUserService Start");
		this.userService = userService;
		logger.info("setUserService end");
	}
	
	@RequestMapping("/loginForm.htm")
	public ModelAndView showLoginForm()
	{
//		boolean dayResult=getDayOfWeekForMaintainence();
//		if(dayResult)
//		{
//			ModelAndView modelAndView= new ModelAndView("maintainence");
//			return modelAndView;
//		}
		logger.info("showLoginForm Start");
		ModelAndView modelAndView= new ModelAndView("loginForm");
		logger.info("showLoginForm end");
		return modelAndView;
		
	}
	
	@RequestMapping("/regForm.htm")
	public ModelAndView showRegistrationForm()
	{
		logger.info("showRegistrationForm start");
		ModelAndView modelAndView= new ModelAndView("regForm");
		logger.info("showRegistrationForm end");
		return modelAndView;
		
	}
	@RequestMapping("/submitForm.htm")
	public ModelAndView submitForm(@Valid@ModelAttribute("user")User user,BindingResult result)
	{

		logger.info("submitForm start");
		if(result.hasErrors())
		{
			ModelAndView modelAndView1= new ModelAndView("regForm");
			logger.info("submitForm end");
			return modelAndView1;
		}
		else
		{
			userService.addUser(user);
			ModelAndView modelAndView= new ModelAndView("welcome");
			logger.info("submitForm end");
			return modelAndView;
		}
		
		
	}
	
	@RequestMapping("/loginFormSubmit.htm")
	public ModelAndView validateUser(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) 
	{
		logger.info("validateUser start");
		session.setAttribute("USERNAME", username);
		Boolean result=userService.getUser(username, password);
		if(result)
		{
			//List<Contact> contactList=userService.getContact();
			ModelAndView modelAndView= new ModelAndView("displayList");
			modelAndView.addObject("username",username);
			modelAndView.addObject("contacts",userService.getContact(session));
			logger.info("validateUser end");
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView1= new ModelAndView("loginForm");
			logger.info("validateUser end");
			return modelAndView1;
		}


		
		
	}
	/*public boolean getDayOfWeekForMaintainence()
	{
		Calendar calendar=Calendar.getInstance();
		int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek==4)
		{
			return true;
		}
		else
		{
			return false;
		}
	}*/
	
	


}
