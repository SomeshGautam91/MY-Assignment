/**
 * 
 */
package com.yash.springrestintegrationwithangularjsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springrestintegrationwithangularjs.model.User;
import com.yash.springrestintegrationwithangularjs.service.UserService;

/**
 * @author somesh.kumar
 *
 */
@Controller
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	private List<User> listOfUsers=null;
	
	@ResponseBody
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers()
	{
		listOfUsers=userService.getAllUsers();
		return listOfUsers;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/registerUser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<User> registerUser(@RequestBody User user)
	{
		System.out.println("inside register User");
		System.out.println("user email in controller----"+user.getUserEmail());
		listOfUsers=userService.insertUser(user);
		return listOfUsers;
	}

	@ResponseBody
	@RequestMapping(value="/updateUser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<User> editUser(@RequestBody User user)
	{
		System.out.println("inside Edit User");
		listOfUsers=userService.editUser(user);
		return listOfUsers;
	}
	@ResponseBody
	@RequestMapping(value="/deleteUser/{index}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> deleteUser(@PathVariable("index") int index)
	{
		listOfUsers=userService.deleteUser(index);
		return listOfUsers;
	}
	
}
