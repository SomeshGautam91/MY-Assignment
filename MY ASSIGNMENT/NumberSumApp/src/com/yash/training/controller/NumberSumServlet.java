package com.yash.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.training.model.NumberSum;
import com.yash.training.service.NumberSumService;


@WebServlet("/SumServlet")
public class NumberSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting form parameters
		int number1=Integer.parseInt(request.getParameter("num1"));
		int number2=Integer.parseInt(request.getParameter("num2"));
		
		//Populating NumberSum Model with form data
		NumberSum numberObj=new NumberSum();
		numberObj.setNumber1(number1);
		numberObj.setNumber2(number2);
		
		//Using NumberSumService to get two number sum
		int sum=NumberSumService.getTwoNumberSum(number1, number2);
		
		//Setting sum into Attribute 
		request.setAttribute("Sum", sum);
		
		
		//dispatch request to NumberSumView
		request.getRequestDispatcher("/NumberSumView").forward(request,response);
		
	}

}
