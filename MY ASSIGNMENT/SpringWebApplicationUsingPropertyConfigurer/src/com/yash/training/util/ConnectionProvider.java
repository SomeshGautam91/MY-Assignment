package com.yash.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider
{
	private String URL;
	private String username;
	private String password;
	private String driverName;
	private Connection connection=null;
	
	public ConnectionProvider()
	{
		
	}
	
	
	public void setURL(String uRL) {
		URL = uRL;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	
	
	
	public Connection connect()
	{
		try 
		{
			Class.forName(driverName);
			connection=DriverManager.getConnection(URL, username, password);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
	public void disconnect()
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/*public ConnectionProvider(String uRL, String username, String password,String driverName) 
	{
		super();
		URL = uRL;
		this.username = username;
		this.password = password;
		this.driverName = driverName;
	}*/
	
	
}
