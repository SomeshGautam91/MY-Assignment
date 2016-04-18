package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> en = getServletContext().getInitParameterNames();
		PrintWriter pw= response.getWriter();
		
		while(en.hasMoreElements())
		{
			String param=en.nextElement();
			String value= getServletContext().getInitParameter(param);
			pw.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
		}
	}

}
