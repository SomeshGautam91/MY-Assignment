package com.yash.training.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yash.training.domain.User;
import com.yash.training.service.UserService;
import com.yash.training.service.UserServiceIntf;


 
@WebServlet("/NU")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =LoggerFactory.getLogger(NewUser.class);
       
    SimpleDateFormat formatDate=new SimpleDateFormat("yyyy-MM-dd");
    Date dob=null;
    public NewUser() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String name=request.getParameter("username");
			String contactno=request.getParameter("contactno");
			dob = formatDate.parse(request.getParameter("dob"));
			java.sql.Date sqlDate=new java.sql.Date(dob.getTime());
			String address=request.getParameter("address");
			String id=request.getParameter("userid");
			String pwd=request.getParameter("password");
			
			User newUser=new User(name,contactno,sqlDate,address,id,pwd);
			
			UserServiceIntf e= new UserService();
			e.saveUser(newUser);
			response.sendRedirect("EmpForm.html");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
