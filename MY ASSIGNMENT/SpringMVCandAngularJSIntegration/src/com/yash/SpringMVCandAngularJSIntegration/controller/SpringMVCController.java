package com.yash.SpringMVCandAngularJSIntegration.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.SpringMVCandAngularJSIntegration.model.UserDetails;

@Controller
public class SpringMVCController
{
	@RequestMapping(value="/getUser",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails getUser()
	{
		UserDetails user= new UserDetails();
		user.setName("Somesh");
		user.setEmailId("samkane007@gmail.com");
		return user;
	}
}
