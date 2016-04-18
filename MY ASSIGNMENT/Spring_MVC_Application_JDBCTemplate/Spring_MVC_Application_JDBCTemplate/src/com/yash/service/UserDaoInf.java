package com.yash.service;

import java.sql.SQLException;
import java.util.List;

import com.yash.model.Contact;
import com.yash.model.User;

public interface UserDaoInf {
	
	public  User checkUser(User pr) throws SQLException, ClassNotFoundException;
	public boolean SaveUser(User us) throws SQLException, ClassNotFoundException;
	public boolean SaveContact(Contact us,String username) throws SQLException, ClassNotFoundException;
	public List<Contact> ContactRetrive(Contact pr,String username) throws SQLException, ClassNotFoundException;
	public  boolean DeleteContact(int id) throws SQLException, ClassNotFoundException;
	public boolean updateContact(Contact us) throws SQLException, ClassNotFoundException;
	public List<Contact> ContactRetrivebyid(Contact pr,String username) throws SQLException, ClassNotFoundException;


}
