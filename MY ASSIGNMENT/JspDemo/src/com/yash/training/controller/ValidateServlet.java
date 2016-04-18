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
import com.yash.training.pojo.JspJavaBean;



public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
	Statement stmt=null; 
	ConnectionProvider cp=null;
	
	public void init() throws ServletException {
		
				String URL=getServletConfig().getInitParameter("URL");
				String driverName=getServletConfig().getInitParameter("driverName");
				String password=getServletConfig().getInitParameter("password");
				String userName=getServletConfig().getInitParameter("username");
				System.out.println("URL :"+ URL);
				cp = new ConnectionProvider(URL, userName,password,driverName);
				try 
				{
					con=(Connection) cp.connect();
				} 
				catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=validate((String) request.getAttribute("name"),(String) request.getAttribute("password"));
		HttpSession hs=null;
		if(status)
		{
			hs=request.getSession(true);
			
			hs.setAttribute("name", (String) request.getAttribute("name"));
			
			hs.setAttribute("password", (String) request.getAttribute("password"));
			
			getServletContext().getRequestDispatcher("/NewLoginSuccess.jsp").forward(request,response);
		}
		else
		{
			getServletContext().getRequestDispatcher("/loginError.jsp").forward(request,response);
		}
	}
	public boolean validate(String name,String pwd)
	{
		String sql="select username,password from customer";
		try 
	 	{
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String username=rs.getString("username");
				String password=rs.getString("password");
				if(username.equals(name) && password.equals(pwd))
				{
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
