package com.yash.training.driver;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.yash.training.beans.Test;

public class Driver {
	
	public static void main(String args[])
	{
		//finding the xml
		Resource resource= new ClassPathResource("resources/springbeans.xml");
		
		//loading xml
		//BeanFactory factory= new XmlBeanFactory(resource);
		
		ApplicationContext context= new ClassPathXmlApplicationContext("resources/springbeans.xml");
		//Demanding the object
		
		Test test=(Test)context.getBean("test");
		//Test test=(Test) factory.getBean("test");
		
		test.show();
		
	}

}
