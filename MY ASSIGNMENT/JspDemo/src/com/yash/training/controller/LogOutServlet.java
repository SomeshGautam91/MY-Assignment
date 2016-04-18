package com.yash.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LOS")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
         
		 request.getSession(true).invalidate();
         getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
	}
}