package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class SumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();
		int number1=0;
		int number2=0;
		int sum=0;
		
		if(request.getParameter("hidden")==null)
		{
			if(session.isNew())
			{	
				number1=Integer.parseInt(request.getParameter("n1"));
				number2=Integer.parseInt(request.getParameter("n2"));
			}
			else
			{
				number1=(int)session.getAttribute("FirstNumber");
				number2=Integer.parseInt(request.getParameter("newnumber"));
			
			}
		
			sum=number1+number2;
		
			Date date = new Date(session.getCreationTime());
			Date newDate= new Date(session.getLastAccessedTime());
		
//			out.println("session creation time: "+ date);
//			out.println("JSESSION ID :"+session.getId());
//			out.println("session last accessed Time :"+newDate);
//			out.println("session max inactive interval :"+session.getMaxInactiveInterval());
//			out.println("session servlet context :"+session.getServletContext());
//			out.println("session IS NEW :"+session.isNew());
		
		
		
			session.setAttribute("FirstNumber",sum);
		
			out.println("Sum is "+ sum);
			out.println("<form action='#' method='post'>");
			out.println("<input type='text' name='newnumber'/><br>");
			out.println("<input type='submit'  value='Sum'/>");
			out.println("</form>");
		
			out.println("<form action='#' method='post'>");
			out.println("<input type='hidden' name='hidden' value='hdn'/><br>");
			out.println("<input type='submit' value='End' name='hidden'/>");
			out.println("</form>");
		
		}
		else
		{
			out.println("Total Sum is:"+ sum);
			session.invalidate();
			out.println("Session Expired");
			
		}
		
		
		
	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter out= response.getWriter();
//		
//		int number1=(int)getServletContext().getAttribute("FirstNumber");
//		int number2=Integer.parseInt(request.getParameter("newnumber"));
//		
//		out.println("Sum is: "+ (number1+number2));
//		getServletContext().setAttribute("FirstNumber",(number1+number2));
//		out.println("<form action='#' method='post'>");
//		out.println("<input type='text' name='newnumber'/><br>");
//		out.println("<input type='submit'  value='Sum'/>");
//		out.println("</form>");
//	}

}
