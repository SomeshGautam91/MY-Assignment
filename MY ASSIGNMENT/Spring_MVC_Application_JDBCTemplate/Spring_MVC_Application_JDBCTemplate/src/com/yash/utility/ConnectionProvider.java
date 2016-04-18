package com.yash.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnectionProvider {
	
	
    private  String driver;
    private  String url;
    private  String username;
    private  String password;
    private static Connection con=null;
    


    
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setconnection()
	{

		try {
			Class.forName(this.driver);
			con=DriverManager.getConnection(this.url, this.username, this.password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static Connection getconnection() throws ClassNotFoundException, SQLException
    {
    	return con;
    }

}
