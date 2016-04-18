/**
 * 
 */
package com.yash.springrestintegrationwithangularjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yash.springrestintegrationwithangularjs.dao.UserDao;
import com.yash.springrestintegrationwithangularjs.model.User;

/**
 * @author somesh.kumar
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	List<User> listOfUsers=null;
	
	/* (non-Javadoc)
	 * @see com.yash.springrestintegrationwithangularjs.service.UserService#getAllUsers()
	 */
	public List<User> getAllUsers() {
		listOfUsers=userDao.fetchAllUsers();
		return listOfUsers;
		
	
	}

	public List<User> insertUser(User user) {
		return userDao.insertUser(user);
	}

	public List<User> editUser(User user) {
		
		return userDao.updateUser(user);
	}

	public List<User> deleteUser(int index) {
		
		return userDao.deleteUser(index);
	}

}
