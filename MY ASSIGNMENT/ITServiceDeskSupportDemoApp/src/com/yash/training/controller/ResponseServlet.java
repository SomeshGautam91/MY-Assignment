package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		request.getRequestDispatcher("/HC").include(request,response);
		
		
		out.println("<hr>");
		
		
		out.println("<html><body><center>");
		out.println("<h2>Welcome to IT Service Desk</h2>");
		out.println("<p>Your Request for the <h1>"+request.getSession().getAttribute("software")+"</h1> has been submitted.</p>");
		out.println("<p>We will be back to you within 24 Hours</p>");
		out.println("</center></body></html>");
		
		
		out.println("<html><body><form action='FrontController'><center>");
		out.println("<input type='submit' value='Back'/>");
		out.println("</center></form></body></html>");
		
		request.getSession().invalidate();
		
		request.getRequestDispatcher("/VC").include(request,response);
		
		
		
	}

}
