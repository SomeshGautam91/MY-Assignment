package com.deere.dsfj.jdorderweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	
	@ResponseBody
	@RequestMapping(value="/abc")
	public String abc(){
		
		return "Hello world";
	}
}
