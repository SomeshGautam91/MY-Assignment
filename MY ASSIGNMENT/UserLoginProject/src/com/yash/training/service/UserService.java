package com.yash.training.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.yash.training.dao.UserDao;
import com.yash.training.domain.User;

public class UserService implements UserServiceIntf {
	private static final Logger logger =LoggerFactory.getLogger(UserService.class);
	
	UserDao ud=null;
	public UserService()
	{
		ud= new UserDao();
	}
	
	
	
	
	@Override
	public void saveUser(User user) {
		try {
			ud .insert(user);
			logger.info("User Saved Successfully");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(String Id) {
		
		try {
			ud.deleteById(Id);
			logger.info("User Deleted Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(int Id) {
	
			try {
				ud.updateById(Id);
				logger.info("User updated Successfully");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
