package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.db.ConnectionProvider;
import com.yash.training.pojo.CryptoUtil;
import com.yash.training.pojo.JspJavaBean;


public class RegisterValidateServlet extends HttpServlet {
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
		PrintWriter out=response.getWriter();
		String encrptPassword=null;
		JspJavaBean jjb= new JspJavaBean();
		jjb.setName((String)request.getParameter("name"));
		jjb.setContactNo(Integer.parseInt(request.getParameter("contact")));
		jjb.setEmail((String)request.getParameter("email"));
		jjb.setPassword((String)request.getParameter("password"));
		
		System.out.println("Name:"+(String)request.getParameter("name"));
		System.out.println("Contact No:"+request.getParameter("contact"));
		System.out.println("Email:"+(String)request.getParameter("email"));
		System.out.println("Password:"+(String)request.getParameter("password"));
		
		CryptoUtil cl= new CryptoUtil();
		String key=cl.getKey();
		try 
		{
			encrptPassword=cl.encrypt(key,jjb.getPassword());
		} 
		catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidAlgorithmParameterException
				| IllegalBlockSizeException | BadPaddingException e1) 
		{
			
			e1.printStackTrace();
		}
		
		String stuSql="insert into registerCustomer(Name,ContactNo,Email,Password) values ('"+jjb.getName()+"','"+jjb.getContactNo()+"','"+jjb. getEmail()+"','"+encrptPassword+"')";
		
		try 
	 	{
			
			stmt = con.createStatement();
			stmt.executeUpdate(stuSql);
			
			getServletContext().getRequestDispatcher("/registerCustomer.jsp").forward(request,response);
			
	    } 
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }
		
	}
	public void destroy() {
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		  }
}
