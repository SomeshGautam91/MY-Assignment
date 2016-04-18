package com.yash.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.yash.training.bean.User;
import com.yash.training.service.UserService;
import com.yash.training.service.UserServiceImplementation;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Resource resource=new ClassPathResource("resource/spring.xml");
	    BeanFactory factory=new XmlBeanFactory(resource);
		String name=request.getParameter("name");
		long contact=Long.parseLong(request.getParameter("contact"));
		
		User user=new User();
		user.setName(name);
		user.setContact(contact);
		
		//request.getSession().setAttribute("Factory",factory);
		UserService userService=(UserServiceImplementation)factory.getBean("UserService");
		userService.addUser(user);
		System.out.println("In the controller");
		
		
	}

}
