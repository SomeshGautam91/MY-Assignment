package com.yash.training.service;

import com.yash.training.domain.User;

public interface UserServiceIntf {
	
	public void saveUser(User user);
	public void deleteUser(String Id);
	public void updateUser(int Id);

}
