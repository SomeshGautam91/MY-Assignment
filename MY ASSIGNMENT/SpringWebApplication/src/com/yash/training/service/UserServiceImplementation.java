package com.yash.training.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.yash.training.bean.User;
import com.yash.training.dao.UserDao;

@Component
public class UserServiceImplementation implements UserService
{
	@Autowired
	private UserDao userDao;
	private ApplicationContext context=null;
	
	@Override
	public void addUser(User user) 
	{
		System.out.println("inside adduser");
		userDao.saveUser(user);
		
	}

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



}
