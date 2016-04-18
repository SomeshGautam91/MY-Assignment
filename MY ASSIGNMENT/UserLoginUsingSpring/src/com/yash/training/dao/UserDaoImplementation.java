package com.yash.training.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yash.training.pojo.Contact;
import com.yash.training.pojo.User;
import com.yash.training.util.ConnectionProvider;


public class UserDaoImplementation implements UserDao {
	
	Connection connection=null;
	Statement statement=null;
	PreparedStatement pstmt=null;
	
	@Autowired
	ConnectionProvider provider=null;
	
	
	
	
	public ConnectionProvider getProvider() {
		return provider;
	}

	public void setProvider(ConnectionProvider provider) {
		this.provider = provider;
	}

	

	@Override
	public void saveUser(User user) 
	{
	
		String sql="INSERT INTO user(name,contact,email,username,password) VALUES(?,?,?,?,?)";
		try 
		{	connection=provider.connect();
		    pstmt=connection.prepareStatement(sql);
		    pstmt.setString(1, user.getName());
		    pstmt.setLong(2, user.getContact());
		    pstmt.setString(3, user.getEmail());
		    pstmt.setString(4, user.getUsername());
		    pstmt.setString(5, user.getPassword());
			pstmt.executeUpdate();
			System.out.println("data Inserted Successfully");
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		
	}

	@Override
	public boolean getUser(String username, String password) 
	{
		String sql="SELECT * FROM user where(username=? AND password=?)";
		try
		{
			connection=provider.connect();
		    pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.isBeforeFirst())
			{
				return false;
			}
			
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		
		return true;
	}

	@Override
	public List<Contact> saveContact(Contact contact,HttpSession session) 
	{
		List<Contact> contactList=new ArrayList<>();
		String sql="INSERT INTO contact(username,name,phone,email,address) VALUES(?,?,?,?,?)";
		try 
		{	connection=provider.connect();
		    pstmt=connection.prepareStatement(sql);
		    pstmt.setString(1,  (String)session.getAttribute("USERNAME"));
		    pstmt.setString(2,   contact.getName());
		    pstmt.setLong  (3,   contact.getContact());
		    pstmt.setString(4,   contact.getEmail());
		    pstmt.setString(5,   contact.getAddress());
			pstmt.executeUpdate();
			provider.disconnect();
			pstmt.close();
			connection.close();
			System.out.println("data Inserted Successfully");
			contactList=getAllcontact(session);
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		return contactList; 
		
	}

	@Override
	public List<Contact> getAllcontact(HttpSession session) 
	{
		List<Contact> contactList=new ArrayList<>();
		String username=(String) session.getAttribute("USERNAME");
		String sql="SELECT * FROM contact where username=?";
		try 
		{	connection=provider.connect();
		    pstmt=connection.prepareStatement(sql);
		    pstmt.setString(1, username);
		    ResultSet rs = pstmt.executeQuery();
		    while(rs.next())
		    {
		    	Contact contact=new Contact();
		    	contact.setId(rs.getInt(1));
		    	contact.setName(rs.getString(3));
		    	contact.setContact(rs.getLong(4));
		    	contact.setEmail(rs.getString(5));
		    	contact.setAddress(rs.getString(6));
		    	contactList.add(contact);
		
		    }
			
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		return contactList;
	}

	@Override
	public List<Contact> deleteContact(String uid,HttpSession session)  
	{
		int id;
		List<Contact> contactList=new ArrayList<>();
		String username=(String) session.getAttribute("USERNAME");
		String deleteSql="DELETE  FROM contact WHERE id=?";
		try 
		{	id=Integer.parseInt(uid);
			connection=provider.connect();
			pstmt=connection.prepareStatement(deleteSql);
		    pstmt.setInt(1, id);
		    pstmt.executeUpdate();
		    provider.disconnect();
					
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		finally
		{	String sql="SELECT * FROM contact where username=?";
			try 
			{
				connection=provider.connect();
				pstmt=connection.prepareStatement(sql);
				pstmt.setString(1, username);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
				    	Contact contact=new Contact();
				    	contact.setName(rs.getString(3));
				    	contact.setContact(rs.getLong(4));
				    	contact.setEmail(rs.getString(5));
				    	contact.setAddress(rs.getString(6));
				    	contactList.add(contact);
				    	
				}
				provider.disconnect();
			} 
			catch (SQLException | ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return contactList;
	}

	@Override
	public List<Contact> searchContact(String search, HttpSession session) 
	{
		long fetchFromPhone;
		String fetchFromName;
		String fetchFromEmail;
		String fetchFromAddress;
		String sqlQuery;
		ResultSet rs;
		
		
		String name=(String) session.getAttribute("USERNAME");
		List<Contact> contactList=new ArrayList<>();
		String sql1="SELECT * FROM contact where username=? AND phone LIKE ?";
		String sql2="SELECT * FROM contact where username=? AND name LIKE ? OR email LIKE ? OR address LIKE ?";
		
		try 
		{
				connection=provider.connect();
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
				e1.printStackTrace();
		}
	
		try 
		{
			fetchFromPhone=Long.parseLong(search);
			pstmt=connection.prepareStatement(sql1);
			pstmt.setString(1, name);
			pstmt.setLong(2,fetchFromPhone);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			    	Contact contact=new Contact();
			    	contact.setName(rs.getString(3));
			    	contact.setContact(rs.getLong(4));
			    	contact.setEmail(rs.getString(5));
			    	contact.setAddress(rs.getString(6));
			    	contactList.add(contact);
			    	
			}
			
			
			
			
		} 
		catch (SQLException |NumberFormatException e) 
		{
			fetchFromName=search;
			fetchFromEmail=search;
			fetchFromAddress=search;
			
			
			try 
			{
				pstmt=connection.prepareStatement(sql2);
				pstmt.setString(1,"%"+search+"%");
                pstmt.setString(2,"%"+fetchFromName+"%");
                pstmt.setString(3,"%"+fetchFromEmail+"%");
                pstmt.setString(4,"%"+fetchFromAddress+"%");
                rs = pstmt.executeQuery();
                while(rs.next())
    			{
    			    	Contact contact=new Contact();
    			    	contact.setName(rs.getString(3));
    			    	contact.setContact(rs.getLong(4));
    			    	contact.setEmail(rs.getString(5));
    			    	contact.setAddress(rs.getString(6));
    			    	contactList.add(contact);
    			    	
    			}
                provider.disconnect();
    			connection.close();
    			pstmt.close();
    			rs.close();
			}
			catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		return contactList;
	}

	@Override
	public List<Contact> updateContact(Contact contact, HttpSession session)   {
		ResultSet rs;
		List<Contact> contactList=null;
		String sql="UPDATE contact SET phone=?,email=?,address=?,name=? WHERE id=?";
		try 
		{
			connection=provider.connect();
			pstmt=connection.prepareStatement(sql);
			pstmt.setLong(1, contact.getContact());
			pstmt.setString(2,contact.getEmail());
			pstmt.setString(3,contact.getAddress());
			pstmt.setString(4,contact.getName());
			pstmt.setInt(5,Integer.parseInt((String)session.getAttribute("uid")));
			int n=pstmt.executeUpdate();
			provider.disconnect();
			connection.close();
			pstmt.close();
			if(n==1)
			{
				 contactList= getAllcontact(session);
				 System.out.println(contactList);
			}
		
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return contactList;
	}
	

}
