package com.yash.training.listener;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.yash.training.controller.LogOutServlet;
import com.yash.training.controller.ValidateServlet;


@WebListener
public class NewSessionListener implements HttpSessionListener  {
	
	
 
  
	
    public NewSessionListener() {
        
    }


    public void sessionCreated(HttpSessionEvent arg0)  
    {
    	
    	Logger logger=Logger.getLogger(ValidateServlet.class.toString());
        try 
        {
			FileHandler fileHandler=new FileHandler("d://Newlog3.txt",true);
			SimpleFormatter formatter= new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			logger.addHandler(fileHandler);
		   
		
         } 
        catch (SecurityException | IOException e)
        {
			
			e.printStackTrace();
		}
    	
    	//(Logger) arg0.getSession().getServletContext().getAttribute("Logger");
    	logger.info("Session Created :"+new Date(arg0.getSession().getCreationTime()));
    	
    	
    	
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  
    { 
    	Logger logger=Logger.getLogger(LogOutServlet.class.toString()); 
    	try 
         {
 			FileHandler fileHandler=new FileHandler("d://Newlog3.txt",true);
 			SimpleFormatter formatter= new SimpleFormatter();
 			fileHandler.setFormatter(formatter);
 			logger.addHandler(fileHandler);
 		   
 		
          } 
         catch (SecurityException | IOException e)
         {
 			
 			e.printStackTrace();
 		 }
    	
    	
    	logger.info("Session Destroyed :"+ new Date(arg0.getSession().getLastAccessedTime()));
    	logger.info("-------------------------");
    }
	
}
