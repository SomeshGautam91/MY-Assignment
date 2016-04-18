package com.yash.training.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Welcome,"+request.getAttribute("fname")+" "+request.getAttribute("lname")+"</h2>");
		out.println("</body></html>");

	}

}


