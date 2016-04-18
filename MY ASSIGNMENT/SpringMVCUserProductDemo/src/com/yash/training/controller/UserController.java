package com.yash.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/add.ds")
	public ModelAndView addUser()
	{
		
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","User Added");
		return model;
	}
	@RequestMapping("/delete.ds")
	public ModelAndView deleteUser()
	{
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","User deleted");
		return model;
	}
	@RequestMapping("/update.ds/{countryName}/{userName}")
	public ModelAndView updateUser(@PathVariable("countryName")String country,@PathVariable("userName") String name)
	{
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","Welcome:"+name+"You are from:"+country);
		//model.addObject("msg","User Updated");
		return model;
	}
	@RequestMapping("/show.ds")
	public ModelAndView showUser()
	{
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","User display");
		return model;
	}

}
