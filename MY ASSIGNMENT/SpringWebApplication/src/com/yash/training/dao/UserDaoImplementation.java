package com.yash.training.dao;



import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.yash.training.bean.User;
import com.yash.training.util.ConnectionProvider;

public class UserDaoImplementation implements UserDao {
	Connection connection=null;
	Statement statement=null;
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
		System.out.println("IN user dao");
		String sql="INSERT INTO USERSREGISTRATION(name,contact) VALUES('"+user.getName()+"','"+user.getContact()+"')";
		try 
		{	connection=provider.connect();
			statement=connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("data Inserted Successfully");
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		
	}

}
