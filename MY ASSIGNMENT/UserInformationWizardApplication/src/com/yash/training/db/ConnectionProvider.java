package com.yash.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private String URL="jdbc:mysql://localhost:3306/mysql";
	private String username="root";
	private String password="root";
	private String driverName="com.mysql.jdbc.Driver";
	
	private Connection con=null;
	
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
