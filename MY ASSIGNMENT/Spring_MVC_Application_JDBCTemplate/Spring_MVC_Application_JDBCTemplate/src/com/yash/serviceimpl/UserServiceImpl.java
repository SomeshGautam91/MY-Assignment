package com.yash.serviceimpl;


import java.sql.SQLException;







import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yash.dao.*;
import com.yash.model.Contact;
import com.yash.model.User;
import com.yash.service.UserServiceInf;

@Service
public class UserServiceImpl implements UserServiceInf{
	
	   @Autowired
	   private UserDaoImpl userDaoImpl;
	   
	 
   public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}


    @Override
	public User Checklogin(User user) throws ClassNotFoundException, SQLException
	   {  
		    User user1=userDaoImpl.checkUser(user);
		 
		    return user1;
		   
	   }
	   

       @Override
	   public  boolean addUser(User user) throws SQLException, ClassNotFoundException
	   {
		  boolean msg;
		  
       if(userDaoImpl.SaveUser(user))
		   {
			   msg=true;
		   }
		   else 
		   {
			   msg=false;
		   }
		     return msg;
	   }
	   
       @Override
	   public  boolean addContact(Contact contact,String username) throws SQLException, ClassNotFoundException
	   {
		  boolean msg;
		  
          if(userDaoImpl.SaveContact(contact,username))
		   {
			   msg=true;
		   }
		   else 
		   {
			   msg=false;
		   }
		     return msg;
	   }
       
       @Override
	   public List<Contact> ContactRetrive(Contact contact,String name) throws SQLException, ClassNotFoundException
	   {
		   List<Contact> list;
		   list=userDaoImpl.ContactRetrive(contact,name);
		   return list;
	   }
       
       @Override
      public boolean removeContact(int id) throws ClassNotFoundException, SQLException
      {

		  boolean msg;
		  
          if(userDaoImpl.DeleteContact(id))
		   {
			   msg=true;
		   }
		   else 
		   {
			   msg=false;
		   }
		     return msg;
    	  
      }
      
       @Override
      public boolean editContact(Contact contact) throws ClassNotFoundException, SQLException
      {

		  boolean msg;
		  
          if(userDaoImpl.updateContact(contact))
		   {
			   msg=true;
		   }
		   else 
		   {
			   msg=false;
		   }
		     return msg;
    	  
      }
      
      @Override
      public List<Contact> ContactRetrivebyid(Contact contact,String name) throws SQLException, ClassNotFoundException
	   {
		   List<Contact> list;
		   list=userDaoImpl.ContactRetrivebyid(contact,name);
		   return list;
	   }
}
