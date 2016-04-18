package com.yash.training.dao;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.yash.training.db.ConnectionProvider;
import com.yash.training.exception.MyException;
import com.yash.training.model.Users;

public class UserDao {
	ConnectionProvider connectionProvider=null;
	
	
	public UserDao()
	{
		connectionProvider=new ConnectionProvider();
	}
	
	public void insertUser(Users user) throws MyException 
	{
		
		String sql="INSERT INTO users (userName,contact,email) VALUES ('"+user.getName()+"','"+user.getContact()+"','"+user.getEmail()+"')";
		try 
	 	{
			Connection connection;
			connection = connectionProvider.connect();
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
			
			System.out.println("Inserted successfully");
			connection.close();
		}
		catch (Exception e)
		{
			throw new MyException("Data Not saved");
	    }
	}
	/*public Users getSingleUser(String id) throws MyException
	{
		Connection connection;
		Statement statement=null;
		String name=null;
		String contact=null;
		String email=null;
		try 
		{
			connection = connectionProvider.connect();
			statement=connection.createStatement();
		} 
		catch (Exception e)
		{
			throw new MyException("Data can't Accessed");
	    }
		String sql="SELECT userName,contact,email FROM users WHERE userId='"+id+"'";
		try 
		{
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				 name=rs.getString("userName");
				 contact=rs.getString("contact");
				 email=rs.getString("email");
				
			}
			return new Users(name,contact,email);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}*/
	public ArrayList<Users> getUser(String id) throws MyException
	{
		ArrayList<Users> users= new ArrayList<Users>();
		Connection connection;
		Statement statement=null;
		String name=null;
		String contact=null;
		String email=null;
		try 
		{
			connection = connectionProvider.connect();
			statement=connection.createStatement();
		} 
		catch (Exception e)
		{
			throw new MyException("Data can't Accessed");
	    }
		if(id.isEmpty())
		{
			String sql="SELECT userName,contact,email from users";
			try 
			{
				
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next())
				{
					 name=rs.getString("userName");
					 contact=rs.getString("contact");
					 email=rs.getString("email");
					
					users.add(new Users(name,contact,email));
				}
				return users;
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
	
			return users;
		}
		else
		{
			boolean status =isNumeric(id);
			if(status)
			{
				String sql="SELECT userName,contact,email FROM users WHERE userId='"+id+"'";
				try 
				{
				
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next())
					{
						name=rs.getString("userName");
						contact=rs.getString("contact");
						email=rs.getString("email");
						users.add(new Users(name,contact,email));
					}
					return users;
				}
			
				catch (Exception e)
				{
					e.printStackTrace();
				}	
				return users;
			}
			else
			{
				throw new MyException("NumberFormatException");
			}
			
		}
		
	}
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");
	}
	public Users searchUser(String username,String password) throws MyException
	{
		Connection connection;
		Statement statement=null;
		String name=null;
		String contact=null;
		String email=null;
		Users user=null;
		try 
		{
			connection = connectionProvider.connect();
			statement=connection.createStatement();
		} 
		catch (Exception e)
		{
			throw new MyException("Data can't Accessed");
	    }
		
		try 
		{
			String sql="SELECT userName,contact,email FROM users WHERE userName='"+username+"' and Password='"+password+"'";
			ResultSet rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst() ) 
			{    
				 return null; 
			}
			else
			{
				while(rs.next())
				{
					name=rs.getString("userName");
					contact=rs.getString("contact");
					email=rs.getString("email");
					user=new Users(name,contact,email);
					return user; 
				}
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return user;	
	
		
	}
}
