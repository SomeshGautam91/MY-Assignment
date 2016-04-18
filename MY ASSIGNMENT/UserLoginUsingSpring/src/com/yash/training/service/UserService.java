package com.yash.training.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yash.training.pojo.Contact;
import com.yash.training.pojo.User;

public interface UserService {
	
	public void addUser(User user);
	public boolean getUser(String username,String password);
	public List<Contact> addContact(Contact contact,HttpSession session);
	public List<Contact> getContact(HttpSession session);
	public List<Contact> deleteContact(String uid,HttpSession session);
	public List<Contact> searchContact(String input,HttpSession session);
	public List<Contact> updateContact(Contact contact,HttpSession session);
}
