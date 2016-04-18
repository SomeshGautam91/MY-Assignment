package com.yash.training.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.training.db.ConnectionProvider;



public class ServiceDeskServlet extends HttpServlet {
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
		HttpSession session=request.getSession();
		
		
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("software",request.getParameter("software"));
		session.setAttribute("os", request.getParameter("os"));
		session.setAttribute("complain",request.getParameter("complain"));
		
		
		boolean status=validate((String)request.getParameter("email"),request);
		
		if(status)
		{
			String sql="INSERT INTO ComplainInfo(Email,Software,OS,ProbDesc) VALUES ('"+(String)request.getParameter("email")+"','"+(String)request.getParameter("software")+"','"+(String)request.getParameter("os")+"','"+(String)request.getParameter("complain")+"')";
			
			try 
			{
				stmt = con.createStatement();
				stmt.executeUpdate(sql);
				getServletContext().getRequestDispatcher("/RC").forward(request,response);
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		    
		}
		else
		{
			getServletContext().getRequestDispatcher("/Register.html").forward(request,response);
		}
		
		
		
		
	}
	public boolean validate(String email,HttpServletRequest request)
	{
		String sql="SELECT First_Name,Last_Name,Email FROM EmployeeInfo";
		try 
	 	{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String Email=rs.getString("Email");
				
				if(email.equals(Email) )
				{
					request.setAttribute("fname",rs.getString("First_Name"));
					request.setAttribute("lname",rs.getString("Last_Name"));
					return true;
				}
			}
			
	    } 
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }
		return false;
	}
		

}
