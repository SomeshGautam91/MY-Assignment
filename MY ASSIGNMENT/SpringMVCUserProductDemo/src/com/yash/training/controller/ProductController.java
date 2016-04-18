package com.yash.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	
	@RequestMapping("/add.ds")
	public ModelAndView addProduct()
	{
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","Product Added");
		return model;
		
	}
	@RequestMapping("/delete.ds")
	public ModelAndView deleteProduct()
	{
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","Product deleted");
		return model;
	}
	@RequestMapping("/update.ds")
	public ModelAndView updateProduct()
	{
		ModelAndView model=new ModelAndView("success");
		model.addObject("msg","Product upated");
		return model;
	}

	@RequestMapping("/show.ds")
	public ModelAndView showProduct()
	{
		
		
		
		return null;
	}


}
