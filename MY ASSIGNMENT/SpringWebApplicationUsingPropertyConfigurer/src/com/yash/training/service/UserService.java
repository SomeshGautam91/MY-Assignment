package com.yash.training.service;

import com.yash.training.bean.User;
import com.yash.training.dao.UserDao;

public class UserService {
	
	private UserDao userDao;

	private void addUser(User user) {
		userDao.saveUser(user);

	}
}
