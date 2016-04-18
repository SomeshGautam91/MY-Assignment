package com.yash.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider{

	    private String username="root";
		private String password="root";
		private String url="jdbc:mysql://localhost:3306/mysql";
		private String driverClassName="com.mysql.jdbc.Driver";
		Connection con=null;
		
		

		public ConnectionProvider(String url,String username, String password, 
				String driverClassName) {
			this.username = username;
			this.password = password;
			this.url = url;
			this.driverClassName = driverClassName;
		}
		

		public ConnectionProvider() {
			
		}


		public Connection connect() throws ClassNotFoundException, SQLException
		{
			 
			 Class c=Class.forName(driverClassName);
			 con=DriverManager.getConnection(url, username, password);
			 return con;
			
		}
		
		public void disconnect() throws SQLException
		{
			con.close();
		}

	}


