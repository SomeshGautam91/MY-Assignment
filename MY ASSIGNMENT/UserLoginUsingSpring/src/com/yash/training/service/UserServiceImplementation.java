package com.yash.training.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yash.training.pojo.Contact;
import com.yash.training.pojo.User;
import com.yash.training.dao.UserDao;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	private UserDao userDao;
	private ApplicationContext context=null;
	
	public UserDao getUserDao() 
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao) 
	{
		this.userDao = userDao;
	}
	
	@Override
	public void addUser(User user) 
	{
		
		userDao.saveUser(user);
		
	}
	@Override
	public boolean getUser(String username,String password) 
	{
		
		return (userDao.getUser(username, password));
	}

	@Override
	public List<Contact> addContact(Contact contact,HttpSession session) {
		List<Contact> contacts=userDao.saveContact(contact,session);
		return contacts;
		
	}

	@Override
	public List<Contact> getContact(HttpSession session) {
		List<Contact> contacts=userDao.getAllcontact(session);
		return contacts;
	}

	@Override
	public List<Contact> deleteContact(String uid,HttpSession session) {
		List<Contact> contacts=userDao.deleteContact(uid, session);
		return contacts;
	}

	@Override
	public List<Contact> searchContact(String input, HttpSession session) {
		List<Contact> contactList=userDao.searchContact(input, session);
		return contactList;
	}

	@Override
	public List<Contact> updateContact(Contact contact, HttpSession session) {
		List<Contact> contactList=userDao.updateContact(contact, session);
		return contactList;
	}

	

	

	


}
