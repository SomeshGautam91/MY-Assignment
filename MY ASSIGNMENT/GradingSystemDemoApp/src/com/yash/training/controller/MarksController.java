package com.yash.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.mapper.Mapper;
import com.yash.training.pojo.StudentPojo;




public class MarksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		StudentPojo sp=new Mapper().getMapperToPojo(request);
		request.setAttribute("Student",sp);
	    request.getRequestDispatcher("DisplayServlet").forward(request,response);
		
	}

}
