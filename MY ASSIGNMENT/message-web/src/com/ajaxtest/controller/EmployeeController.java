package com.ajaxtest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxtest.dao.EmployeeDao;
import com.ajaxtest.model.Employee;
import com.google.gson.Gson;

public class EmployeeController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static String INSERT="/addEmployee";
	private static String EMPLOYEE_LIST="/employeeList.jsp";
	
	private EmployeeDao eDao;
	
	
		
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String action=request.getParameter("action");
		eDao= new EmployeeDao();
	
		if(action.equalsIgnoreCase("listUser")){
			List<Employee> empl= eDao.getEmployeeList();
			Gson gson=new Gson();
			String employees=gson.toJson(empl);
			request.setAttribute("employees", employees);
		}
			
		RequestDispatcher view= request.getRequestDispatcher(EMPLOYEE_LIST);
		try {
			view.forward(request, response);
			//view.include(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String action=request.getParameter("action");
		// Add Employee
		eDao= new EmployeeDao();
		if(action.equalsIgnoreCase("addEmployee")){
			Employee employee= new Employee();
			
			employee.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
			employee.setEmp_name(request.getParameter("emp_name"));
			employee.setEmp_loc(request.getParameter("emp_loc"));
			employee.setEmp_desig(request.getParameter("emp_desig"));
			employee.setEmp_depart(request.getParameter("emp_depart"));
			
			
			
			eDao.addEmployee(employee);
			List<Employee> empl= eDao.getEmployeeList();
			Gson gson=new Gson();
			String employees=gson.toJson(empl);
			
			
			
			
			try {
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(employees);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Delete Employee
		if(action.equalsIgnoreCase("deleteEmployee")){
			String eId= request.getParameter("emp_id");
			eDao.deleteEmployee(eId);
			
			List<Employee> empl= eDao.getEmployeeList();
			Gson gson=new Gson();
			String employees=gson.toJson(empl);
		
			try {
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(employees);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Update Employee
		if(action.equalsIgnoreCase("editEmployee")){
			Employee employee= new Employee();
			
			employee.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
			employee.setEmp_name(request.getParameter("emp_name"));
			employee.setEmp_loc(request.getParameter("emp_loc"));
			employee.setEmp_desig(request.getParameter("emp_desig"));
			employee.setEmp_depart(request.getParameter("emp_depart"));
			eDao.updateEmployee(employee);
			List<Employee> empl= eDao.getEmployeeList();
			Gson gson=new Gson();
			String employees=gson.toJson(empl);
			try {
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(employees);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
		}
		
	}

