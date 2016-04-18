/**
 * 
 */
package com.yash.springrestintegrationwithangularjs.service;

import java.util.List;

import com.yash.springrestintegrationwithangularjs.model.User;

/**
 * @author somesh.kumar
 *
 */
public interface UserService {
	
	public List<User> getAllUsers();
	public List<User> insertUser(User user);
	public List<User> editUser(User user);
	public List<User> deleteUser(int index);

}
