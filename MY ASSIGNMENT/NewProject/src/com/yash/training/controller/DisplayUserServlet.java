package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.db.ConnectionProvider;
import com.yash.training.exception.MyException;
import com.yash.training.model.Users;
import com.yash.training.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class DisplayUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("userid");
		
		UserService userService=new UserService();
		
		Users user=null;
		ArrayList<Users> users=null;
		try 
		{
				users = userService.getUser(id);
				request.setAttribute("List",users);
		}
		catch (MyException e) 
		{
				e.printStackTrace();
		}
	
		request.getRequestDispatcher("userview.jsp").forward(request,response);
			
	}
		
		
		
		
	
	
	}


