package com.yash.sumcomponent.service;

import java.util.List;

import com.yash.sumcomponent.model.User;

public interface UserServiceIfc
{
	
	public List<User> getAllUser();
	public List<User> insertUser(User user);
	public List<User> searchUserByName(User user);
	public List<User> searchUserById(User user);
	public List<User> deleteUser(int id);
	public List<User> updateUser(User user);
}
