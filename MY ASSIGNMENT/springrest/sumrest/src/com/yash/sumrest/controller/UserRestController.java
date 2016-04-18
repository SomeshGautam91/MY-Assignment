package com.yash.sumrest.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.sumcomponent.model.Sum;
import com.yash.sumcomponent.model.User;
import com.yash.sumcomponent.service.UserServiceIfc;

@Controller
public class UserRestController
{
	
	@Autowired
	public UserServiceIfc userServiceIfc;
	
	
	@RequestMapping(value="/fetchAllUser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getAllUsers()
	{
		System.out.println("IN getAllUsers ()");
		
		 return userServiceIfc.getAllUser();
	}
	
	@RequestMapping(value="/insertUser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> insertUser(@RequestBody User user)
	{
		System.out.println("IN Insert User()");
		
		 return userServiceIfc.insertUser(user);
	}
	@RequestMapping(value="/searchUserByName",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> searchUserByName(@RequestBody User user)
	{
		 
		 System.out.println(user.getName());
		 return userServiceIfc.searchUserByName(user);
		
		
	}
	
	@RequestMapping(value="/searchUserById",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> searchUserById(@RequestBody User user)
	{
		 
		 System.out.println(user.getUserId());
		 return userServiceIfc.searchUserById(user);
		
		
	}
	
	
	
	@RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> deleteUser(@PathVariable("id") int id)
	{
		 System.out.println(id);
		 return userServiceIfc.deleteUser(id);
		
		
	}
	@RequestMapping(value="/updateUser",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> updateUser(@RequestBody User user)
	{
		 
		System.out.println("in upadate "+user.getUserId());
		
		 return userServiceIfc.updateUser(user);
		
		
	}
	
	
	
	
	
}
