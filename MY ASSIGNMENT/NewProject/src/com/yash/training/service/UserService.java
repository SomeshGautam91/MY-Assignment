package com.yash.training.service;

import java.util.ArrayList;

import com.yash.training.dao.UserDao;
import com.yash.training.exception.MyException;
import com.yash.training.model.Users;

public class UserService {
	UserDao userDao=null;
	
	public UserService()
	{
		userDao=new UserDao();
	}
	
	
	public void saveUser(Users user) throws MyException
	{
		userDao.insertUser(user);
	}
	
	public ArrayList<Users> getUser(String id) throws MyException
	{
		ArrayList<Users> users=userDao.getUser(id);
		return users;
	}
	/*public Users getSingleUser(String id) throws MyException
	{
		Users user=userDao.getSingleUser(id);
		return user;
	}*/
}
