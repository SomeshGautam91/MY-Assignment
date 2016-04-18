package com.yash.training.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.db.ConnectionProvider;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con=null;
	Statement stmt=null; 
	ConnectionProvider cp=null;
	
	
	public void init() throws ServletException 
	{
		
		String URL=getServletConfig().getInitParameter("URL");
		String driverName=getServletConfig().getInitParameter("driverName");
		String password=getServletConfig().getInitParameter("password");
		String userName=getServletConfig().getInitParameter("username");
		System.out.println("URL :"+ URL);
		cp = new ConnectionProvider(URL, userName,password,driverName);
		try 
		{
			con=(Connection)cp.connect();
			System.out.println("Connection created");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
    }
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fName=request.getParameter("fname");
		String lName=request.getParameter("lname");
		String mobileNo=request.getParameter("mobile");
		request.setAttribute("fname", fName);
		request.setAttribute("lname",lName);
		
        String empSql="INSERT INTO EmployeeInfo(First_Name,Last_Name,Mobile_No,Email) VALUES ('"+fName+"','"+lName+"','"+mobileNo+"','"+request.getSession().getAttribute("email")+"')";
        String comSql="INSERT INTO ComplainInfo(Email,Software,OS,ProbDesc) VALUES ('"+(String)request.getSession().getAttribute("email")+"','"+(String)request.getSession().getAttribute("software")+"','"+(String)request.getSession().getAttribute("os")+"','"+(String)request.getSession().getAttribute("complain")+"')";
		try 
	 	{
			
			stmt = con.createStatement();
			stmt.executeUpdate(empSql);
			stmt.executeUpdate(comSql);
			getServletContext().getRequestDispatcher("/RC").forward(request,response);
			
	    } 
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }
		
		
		
		
		
		
		
	}

}
