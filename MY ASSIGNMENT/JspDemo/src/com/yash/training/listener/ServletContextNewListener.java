package com.yash.training.listener;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yash.training.controller.LogOutServlet;
import com.yash.training.controller.ValidateServlet;

/**
 * Application Lifecycle Listener implementation class ServletContext
 *
 */
@WebListener
public class ServletContextNewListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextNewListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context=arg0.getServletContext();  
    	
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }
	
}
