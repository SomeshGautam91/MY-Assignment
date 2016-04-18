package com.yash.training.maintainence;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MaintainenceInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception 
	{
		Calendar calendar=Calendar.getInstance();
		int dayOfWeek=calendar.get(calendar.DAY_OF_WEEK);
		int hours=calendar.get(Calendar.HOUR);
		
		if(dayOfWeek==1)
		{
			response.setContentType("text/html");
			response.getWriter().write("<center><h3>Site is Under Construction!!!!</h3></center>");
			
			return false;
		}
//		else if(hours<6)
//		{
//			response.setContentType("text/html");
//			response.getWriter().write("<center><h3>Site is Under Construction!!!!</h3></center>");
//			
//			return false;
//		}
		return true;
	}

}
