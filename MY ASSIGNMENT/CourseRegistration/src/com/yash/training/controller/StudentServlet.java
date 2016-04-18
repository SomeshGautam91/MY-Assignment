package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.pojo.StudentPojo;



public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int availableSeat=8;
	private static int registeredSeat=0;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
//		String courseName=request.getParameter("course");
//		Long contact=Long.parseLong(request.getParameter("txtContact"));
//		String name=request.getParameter("txtName");
//		String gender=request.getParameter("gender");
//		String startDate=request.getParameter("date");
//		String preferBatch=request.getParameter("courseTiming");
//		String desc=request.getParameter("msg");
//		
//		if(availableSeat>=1)
//		{
//			out.println("CourseName-"+courseName);
//			out.println("Contact-"+contact);
//			out.println("Name-"+name);
//			out.println("Gender-"+gender);
//			out.println("startDate-"+startDate);
//			out.println("preferBatch-"+preferBatch);
//			out.println("description-"+desc);
//          StudentPojo sj=new StudentPojo(courseName,contact, name, gender, startDate,preferBatch,desc);
		    availableSeat=availableSeat-1;
		    registeredSeat=registeredSeat+1;
//		    out.println("available seats"+availableSeat);
//			out.println("registered seats"+registeredSeat);
		    request.getRequestDispatcher("/SDB").include(request,response);;
			out.println("Registered Successfully");
			
			
		}
//		else
//		{
//			out.println("Registered Unsuccessfully");
//		}
		
	}

//}
