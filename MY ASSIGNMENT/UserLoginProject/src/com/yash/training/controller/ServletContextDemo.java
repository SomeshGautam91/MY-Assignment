package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yash.training.db.ConnectionProvider;



public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =LoggerFactory.getLogger(ServletContextDemo.class);
       String [] values=new String[4];
       int i=0;
  

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> en = getServletContext().getInitParameterNames();
		PrintWriter pw= response.getWriter();
		
		
		while(en.hasMoreElements())
		{
			String param=en.nextElement();
			values[i]= getServletContext().getInitParameter(param);
			i++;
			//pw.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
		}
		ConnectionProvider cp=new ConnectionProvider(values[0],values[1],values[2],values[3]);
		
	}

}
