package com.yash.training.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String filePath=getServletContext().getInitParameter("Path");
		String realPath=getServletContext().getRealPath(filePath);
		
		FileReader fileReader=new FileReader(realPath);
		
		Properties properties= new Properties();
		
		properties.load(fileReader);
		
		out.println("<html><body  bgcolor='#ffcc99'><center><div style='margin-top:90px; height:400px; width:500px; border:5px solid black'><form action='SC' method='post' style='margin-top:70px;' ><h1>Complain Desk</h1><table  frame='hsides'>");
			
			out.println("<tr>");
				out.println("<td>");
					out.println(properties.getProperty("email")+":");
				out.println("</td>");
				
				out.println("<td>");
				    out.println("<input type='text' name='email' required/>");
			    out.println("</td>");
		    out.println("</tr>");
		   
		    out.println("<tr>");
			    out.println("<td>");
					out.println(properties.getProperty("software")+":");
				out.println("</td>");
			
				out.println("<td>");
			    	out.println("<select name='software' required>"+
									"<option value='eclipseid'>Eclipse ID</option>"+
									"<option value='outlook'>Outlook Web</option>"+
									"<option value='portal'>Portal</option>"+
			    			    "</select>");
			    out.println("</td>");
		    out.println("</tr>");
		   
		    out.println("<tr>");
		    	out.println("<td>");
					out.println(properties.getProperty("os")+":");
				out.println("</td>");
		
				out.println("<td>");
		    		out.println("<select name='os' required>"+ "<option value='window7'>Window 7</option>"+
									"<option value='mac'>Mac</option>"+
									"<option value='dos'>Dos</option>"+
					         	"</select>");
		    	   out.println("</td>");
		   out.println("</tr>");
		   
		   out.println("<tr>");
	    		out.println("<td>");
					out.println(properties.getProperty("pd")+":");
				out.println("</td>");
	
				out.println("<td>");
	    			out.println("<textarea rows='4' cols='30' name='complain' required></textarea>");
	    		out.println("</td>");
	       out.println("</tr>");
	       
	       
	       out.println("<tr>");
//			    out.println("<td>");
//				   
//			    out.println("</td>");
			
			    out.println("<td colspan='2' >");
			      out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
			      		       + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
			                   +"<input type='submit' name='Submit'/>");
		        out.println("</td>");
	       out.println("</tr>");
	       
		   
		   
		   
		   
	    out.println("</table></form></center></div></body></html>");
		
		
	}

}
