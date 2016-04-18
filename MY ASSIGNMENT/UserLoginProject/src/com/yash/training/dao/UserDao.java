package com.yash.training.dao;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.yash.training.db.ConnectionProvider;
import com.yash.training.domain.User;

public class UserDao {
	private static final Logger logger =LoggerFactory.getLogger(UserDao.class);
	
	ConnectionProvider cp;
	public UserDao()
	{
		cp=new ConnectionProvider();
	}
	 
	
	public void insert(User user ) throws ClassNotFoundException, SQLException
	{
		String sql="insert into UserInfo (Name,Contact_No,Dob,Address,UserId,Password) values ('"+user.getName()+"','"+user.getContactNo()+"','"+user.getDob()+"','"+user.getAddress()+"','"+user.getUserId()+"','"+user.getPassword()+"')";
	    Connection con=cp.connect();
	    
	    Statement stmt=con.createStatement();
	    stmt.executeUpdate(sql);
	    System.out.println("Inserted records into the table...");
	    cp.disconnect();
	}

	public void deleteById(String userId ) throws ClassNotFoundException, SQLException
	{
		String sql="delete * from UserInfo where UserId=?";
	    Connection con=cp.connect();
	    PreparedStatement stmt=con.prepareStatement(sql);
	    stmt.setString(4,userId );
	    stmt.executeUpdate(sql);
	    System.out.println("deleted records from the table...");
	    cp.disconnect();
	}
	
	public void updateById(int userId ) throws ClassNotFoundException, SQLException
	{
		String sql="update UserInfo where UserId='"+userId+"'";
	    Connection con=cp.connect();
	    Statement stmt=con.createStatement();
	    stmt.executeUpdate(sql);
	    System.out.println("Update records from the table...");
	    cp.disconnect();
	}	
}
