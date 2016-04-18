package com.yash.hibernatespringintegrationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yash.hibernatespringintegrationapp.pojo.Employee;
import com.yash.hibernatespringintegrationapp.service.EmployeeServiceIfc;

@Controller
@RequestMapping("employee")
public class EmployeeController 
{
	@Autowired
	public EmployeeServiceIfc employeeServiceIfc;
	
	
	
	@RequestMapping(value="/showRegistrationForm.htm", method=RequestMethod.GET)
	public ModelAndView showRegistrationForm()
	{
		ModelAndView modelAndView= new ModelAndView("employeeRegistrationForm");
		return modelAndView;
		
	}
	@RequestMapping(value="/submitRegistrationForm.htm", method=RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@ModelAttribute("employee") Employee employee)
	{
		System.out.println(employee.getName()+"----"+employee.getContact());
		ModelAndView modelAndView= new ModelAndView("success");
		employeeServiceIfc.saveEmployee(employee);
		return modelAndView;
		
	}
	
}
