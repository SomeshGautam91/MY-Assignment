package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yash.training.db.ConnectionProvider;

import java.sql.*;


@WebServlet("/WU")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =LoggerFactory.getLogger(WelcomeServlet.class);
       

    public WelcomeServlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("userid");
		String password=request.getParameter("password");
		String sql="Select password from UserInfo where UserId='"+username+"'";
		ConnectionProvider cp=new ConnectionProvider(); 
		try {
			Connection con=cp.connect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out= response.getWriter();
        out.println("<html>");
		out.println("<head>");
		out.println("<title>");
	    out.println("Welcome User");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Welcome "+username);
		out.println("</h1>");
		
		out.println("</body>");
		out.println("</html>");
}
}
