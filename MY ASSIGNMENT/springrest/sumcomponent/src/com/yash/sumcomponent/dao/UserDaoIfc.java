package com.yash.sumcomponent.dao;

import java.util.List;

import com.yash.sumcomponent.model.User;

public interface UserDaoIfc 
{
	
	public List<User> fetchAllUser();
	public List<User> InsertUser(User user);
	public List<User> searchUserByName(User user);
	public List<User> searchUserById(User user);
	public List<User> deleteUser(int id);
	public List<User> updateUser(User user);
}
