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

/**
 * Servlet implementation class ServletUsingLog
 */
@WebServlet("/ServletUsingLog")
public class ServletUsingLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =LoggerFactory.getLogger(ServletUsingLog.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		logger.info("Web Application Started");
		out.println("hello from Servlet");
		logger.info("Web Application Completed");
		
	}

}
