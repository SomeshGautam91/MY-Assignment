package com.yash.sumcomponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.sumcomponent.dao.UserDaoIfc;
import com.yash.sumcomponent.model.User;

@Service
public class UserServiceImpl implements UserServiceIfc
{
	@Autowired
	private UserDaoIfc userDaoIfc;

	@Override
	public List<User> getAllUser() {
		
		return userDaoIfc.fetchAllUser();

	}

	@Override
	public List<User> insertUser(User user) {
		
		return userDaoIfc.InsertUser(user);
	}

	@Override
	public List<User> searchUserByName(User user) {
	
		return userDaoIfc.searchUserByName(user);
	}

	@Override
	public List<User> deleteUser(int id) {
		return userDaoIfc.deleteUser(id);
		
	}

	@Override
	public List<User> updateUser(User user) {
		
		return userDaoIfc.updateUser(user);
	}

	@Override
	public List<User> searchUserById(User user) {
		
		 return userDaoIfc.searchUserById(user);
	}

}
