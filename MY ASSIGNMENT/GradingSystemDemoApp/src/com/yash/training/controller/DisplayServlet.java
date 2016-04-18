package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.pojo.StudentPojo;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		StudentPojo sp=(StudentPojo) request.getAttribute("Student");
		
		int cMarks=sp.getCoreJavaMarks();
		int sMarks=sp.getSpringMarks();
		int hMarks=sp.getHibernateMarks();
		
		String agg=calulateMarks(cMarks,sMarks,hMarks);
		
		out.println("<h2>Your Grade is: </h2>" + "<h2>" + agg + "</h2>");
		
		out.println("<a href='index.html'><h4>Back</h4></a>");

		request.getRequestDispatcher("VS").include(request, response);
		
		
	}

	public String calulateMarks(int c,int s,int h)
	{
		if((c+s+h)/3>80)
		{
			
			return "Grade A";
		}
		else if((c+s+h)/3<80 && (c+s+h)/3>60)
		{
			return "Grade B";
		}
		else
		{
			return "Grade C";
		}
	}
}
