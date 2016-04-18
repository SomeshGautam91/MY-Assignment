package com.yash.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import com.yash.training.db.ConnectionProvider;
import com.yash.training.pojo.StudentPojo;


public class StudentDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement stmt=null; 
	ConnectionProvider cp=null;
	
	public void init() throws ServletException {
		
				String URL=getServletConfig().getInitParameter("URL");
				String driverName=getServletConfig().getInitParameter("driverName");
				String password=getServletConfig().getInitParameter("password");
				String userName=getServletConfig().getInitParameter("username");
				System.out.println("URL :"+ URL);
				cp = new ConnectionProvider(URL, userName,password,driverName);
				try 
				{
					con=(Connection) cp.connect();
				} 
				catch (ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String courseName=request.getParameter("course");
        Long contact=Long.parseLong(request.getParameter("txtContact"));
        String name=request.getParameter("txtName");
		String gender=request.getParameter("gender");
		String startDate=request.getParameter("date");
		String preferBatch=request.getParameter("courseTiming");
		String desc=request.getParameter("msg");
		StudentPojo sj=new StudentPojo(courseName,contact, name, gender, startDate,preferBatch,desc);
		String stuSql="insert into registerStudent(Name,ContactNo,Gender,CourseName,PreferBatch,Description) values ('"+sj.getName()+"','"+sj.getContact()+"','"+sj. getGender()+"','"+sj.getCourseName()+"','"+sj.getPreferredBatch()+"','"+sj.getDesc()+"')";
		
		try 
	 	{
			
			stmt = con.createStatement();
			stmt.executeUpdate(stuSql);
			out.println("Data Inserted Successfully");
			
	    } 
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }
		
		
		
		
	}
	 public void destroy() {
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		  }

}
