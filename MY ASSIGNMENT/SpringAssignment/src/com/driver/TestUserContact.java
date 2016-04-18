package com.driver;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bean.User;

public class TestUserContact {

	public static void main(String[] args) 
	{
		Resource resource= new ClassPathResource("resources/spring.xml");
		
		BeanFactory factory=new XmlBeanFactory(resource);
		
		User user=(User)factory.getBean("user");
		user.showUserDetails();
	}

}
