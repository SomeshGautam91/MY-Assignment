/**
 * 
 */
package com.yash.springrestintegrationwithangularjs.dao;

import java.util.List;

import com.yash.springrestintegrationwithangularjs.model.User;

/**
 * @author somesh.kumar
 *
 */
public interface UserDao {
	
	public List<User> fetchAllUsers();
	public List<User> insertUser(User user);
	public List<User> updateUser(User user);
	public List<User> deleteUser(int index);

}
