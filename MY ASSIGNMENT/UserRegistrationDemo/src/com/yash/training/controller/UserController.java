package com.yash.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.exception.MyException;
import com.yash.training.model.Users;
import com.yash.training.service.UserService;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getRequestURI();
		String newPath=path.substring(path.lastIndexOf("/")+1);
		
		if(newPath.equals("login.do"))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
		
			UserService userService= new UserService();
			try 
			{
				Users user=userService.searchUser(username, password);
				request.setAttribute("User",user);
				request.getRequestDispatcher("/WEB-INF/view/userResultView.jsp").forward(request,response);
			} 
			catch (MyException e) 
			{
			e.printStackTrace();
			}
		}
	}
}
