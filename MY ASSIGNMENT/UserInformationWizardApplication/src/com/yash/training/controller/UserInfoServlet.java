package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.training.pojo.UserPojo;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs= request.getSession();
		String formNo=request.getParameter("fno");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobileno");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		hs.setAttribute("name", name);
		hs.setAttribute("mobileno", mobile);
		hs.setAttribute("dateofbirth", dob);
		hs.setAttribute("email", email);
		
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String homeno=request.getParameter("houseno");
		hs.setAttribute("street", street);
		hs.setAttribute("city", city);
		hs.setAttribute("houseno", homeno);
		
		String username=request.getParameter("username");
 		hs.setAttribute("username", username);
    	String password=request.getParameter("password");
 		hs.setAttribute("password", password);
 		
 		RequestDispatcher rd=request.getRequestDispatcher("UDBS");
		rd.forward(request, response);
 		
		
	
	}

}
