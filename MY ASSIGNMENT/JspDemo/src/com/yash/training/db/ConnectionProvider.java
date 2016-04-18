package com.yash.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private String URL;
	private String username;
	private String password;
	private String driverName;
	
	private Connection con=null;
	
	
	public ConnectionProvider(String URL, String username, String password,String driverName) {
		this.URL = URL;
		this.username = username;
		this.password = password;
		this.driverName = driverName;
	}

	public Connection connect() throws ClassNotFoundException, SQLException
	{
		 
		 Class c=Class.forName(driverName);
		 con=DriverManager.getConnection(URL, username, password);
		 return con;
	}
	
	public void disconnect() throws SQLException
	{
		con.close();
	}

}
