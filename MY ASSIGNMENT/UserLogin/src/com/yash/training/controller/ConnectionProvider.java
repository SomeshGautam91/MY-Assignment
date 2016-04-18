package com.yash.training.controller;

import java.sql.Connection;

public class ConnectionProvider {
	
	private String username="cdac";
	private String password="cdac123";
	private String url="jdbc:mysql://localhost:3306/mydb";
	Connection con=null;
	
	
	public void connect() throws ClassNotFoundException
	{
		 String driverClassName="";
		 Class c=Class.forName(driverClassName);
		 
		
	}

}
