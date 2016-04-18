package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.pojo.JspJavaBean;



public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		request.setAttribute("name",request.getParameter("name"));
		request.setAttribute("password",request.getParameter("password"));
		
		getServletContext().getRequestDispatcher("/VS").forward(request,response);
		
		
		
		
	
	}

	
	
}
