package com.yash.training.driver;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.yash.training.beans.User;

public class UserDriver {

	public static void main(String[] args) 
	{
		//finding xml
		Resource resource= new ClassPathResource("resources/springbeans.xml");
		
		BeanFactory factory= new XmlBeanFactory(resource); 
		
		User user=(User)factory.getBean("user");
		user.showDetails();

	}

}
