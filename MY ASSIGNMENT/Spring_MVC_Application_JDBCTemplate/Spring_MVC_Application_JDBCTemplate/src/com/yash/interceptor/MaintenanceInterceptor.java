package com.yash.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MaintenanceInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
            
		Date date=new Date();
		System.out.println(date.getHours());
		if(date.getHours()==8)
		{
			response.setContentType("text/html");
		    response.getWriter().write("<h1>Site is Under maintenance</h1>");
		    return false;
		}
		else 
			return true;

            
		
	}

}
