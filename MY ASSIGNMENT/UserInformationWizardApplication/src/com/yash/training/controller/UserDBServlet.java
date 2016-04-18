package com.yash.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.yash.training.db.ConnectionProvider;
import com.yash.training.pojo.UserPojo;

public class UserDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement stmt=null;
		HttpSession hs=request.getSession();
		String name=(String)hs.getAttribute("name");
		String contactNo =(String)hs.getAttribute("mobileno");
		String dob=(String)hs.getAttribute("dateofbirth");
		String email=(String)hs.getAttribute("email");
		String street=(String)hs.getAttribute("street");
		String city=(String)hs.getAttribute("city");
		String houseNo=(String)hs.getAttribute("houseno");
		String username=(String)hs.getAttribute("username");
		String password =(String)hs.getAttribute("password");
	    UserPojo up=new UserPojo(name,contactNo,dob,email,street,city,houseNo,username,password); 			
 	    String sql="insert into personalinfo(Name,ContactNo,DOB,Email,Street,City,HouseNo,Username,Password) values ('"+up.getName()+"','"+up.getContactNo()+"','"+up.getDob()+"','"+up.getEmail()+"','"+up.getStreet()+"','"+up.getCity()+"','"+up.getHouseNo()+"','"+up.getUsername()+"','"+up.getPassword()+"')";
 	    ConnectionProvider cp = new ConnectionProvider();
	    try 
 	    {
		con=(Connection) cp.connect();
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		cp.disconnect();
       } 
	    catch (ClassNotFoundException | SQLException e)
	    {
         e.printStackTrace();
	    }
  	    
		
	    System.out.println("Inserted records into the table...");
	   
		
	
	
	
	
	
	}

}
