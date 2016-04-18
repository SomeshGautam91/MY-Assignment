package com.yash.training.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.training.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@RequestMapping("/regForm.htm")
	public ModelAndView showRegistrationForm()
	{
		ModelAndView modelAndView= new ModelAndView("regForm");
		return modelAndView;
		
	}
	@RequestMapping("/submitForm.htm")
	public ModelAndView submitForm(@Valid@ModelAttribute("user")User user,BindingResult result)
	{
		ModelAndView modelAndView= new ModelAndView("success");
		if(result.hasErrors())
		{
			ModelAndView modelAndView1= new ModelAndView("regForm");
			return modelAndView1;
		}
		return modelAndView;
		
	}
	
}
