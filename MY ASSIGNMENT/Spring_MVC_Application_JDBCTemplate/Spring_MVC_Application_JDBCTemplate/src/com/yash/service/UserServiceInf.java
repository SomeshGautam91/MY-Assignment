package com.yash.service;

import java.sql.SQLException;
import java.util.List;

import com.yash.model.Contact;
import com.yash.model.User;

public interface UserServiceInf {
	
	public User Checklogin(User user) throws ClassNotFoundException, SQLException;
	public  boolean addUser(User user) throws ClassNotFoundException, SQLException;
    public  boolean addContact(Contact contact,String username) throws SQLException, ClassNotFoundException;
    public List<Contact> ContactRetrive(Contact contact,String name) throws ClassNotFoundException, SQLException;
    public boolean removeContact(int id) throws ClassNotFoundException, SQLException;
    public boolean editContact(Contact contact) throws ClassNotFoundException, SQLException;
    public List<Contact> ContactRetrivebyid(Contact contact,String name) throws ClassNotFoundException, SQLException;


}
