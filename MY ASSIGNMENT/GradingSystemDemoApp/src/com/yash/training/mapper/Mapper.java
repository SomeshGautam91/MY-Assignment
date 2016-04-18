package com.yash.training.mapper;

import javax.servlet.http.HttpServletRequest;

import com.yash.training.pojo.StudentPojo;

public class Mapper 
{

	public StudentPojo getMapperToPojo(HttpServletRequest request)
	{
		String name=request.getParameter("name");
		int coreJavaMarks=Integer.parseInt(request.getParameter("jmarks"));
		int springMarks=Integer.parseInt(request.getParameter("smarks"));
		int hibernateMarks=Integer.parseInt(request.getParameter("hmarks"));
		
		StudentPojo sp= new StudentPojo();
		sp.setName(name);
		sp.setCoreJavaMarks(coreJavaMarks);
		sp.setSpringMarks(springMarks);
		sp.setHibernateMarks(hibernateMarks);
		
		return sp;
		
		
		
	}



}
