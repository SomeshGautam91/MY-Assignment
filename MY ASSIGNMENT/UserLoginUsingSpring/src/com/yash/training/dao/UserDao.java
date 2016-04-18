package com.yash.training.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yash.training.pojo.Contact;
import com.yash.training.pojo.User;

public interface UserDao 
{
	public void saveUser(User user); 
	public boolean getUser(String username,String password);
	public List<Contact> saveContact(Contact contact,HttpSession session);
	public List<Contact> getAllcontact(HttpSession session);
	public List<Contact> deleteContact(String uid,HttpSession session);
	public List<Contact> searchContact(String search,HttpSession session);
	public List<Contact> updateContact(Contact contact,HttpSession session);
}

