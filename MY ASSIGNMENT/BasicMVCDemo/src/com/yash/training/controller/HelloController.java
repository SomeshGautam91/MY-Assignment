package com.yash.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	@RequestMapping("/hello.ds")
	public ModelAndView getMessage()
	{
		
		ModelAndView model= new ModelAndView("success");
		model.addObject("msg","Program using Annotation Controller");
		return model;
		
	}

}
