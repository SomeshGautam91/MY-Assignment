package com.yash.training.controller;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yash.training.exception.MyException;
import com.yash.training.model.Users;
import com.yash.training.service.UserService;

/**
 * Servlet implementation class SaveController
 */
@WebServlet("/SaveController")
public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=LoggerFactory.getLogger(SaveController.class);
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		logger.info("");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		
		Users user=new Users(name,contact,email);
		UserService userService=new UserService();
		
		try
		{
			userService.saveUser(user);
		} 
		catch (MyException e) 
		{
			e.printStackTrace();
		}
		request.getRequestDispatcher("saveUserMessage.jsp").forward(request,response);
		
		
	}

}
