/**
 * 
 */
package com.yash.springrestintegrationwithangularjsweb.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author somesh.kumar
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webApplicationContext= new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(SpringConfiguration.class);
		webApplicationContext.setServletContext(servletContext);
		Dynamic servlet=servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		

	}

}
