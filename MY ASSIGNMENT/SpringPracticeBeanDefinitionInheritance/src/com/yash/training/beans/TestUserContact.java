package com.yash.training.beans;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.yash.training.beans.User;
import com.yash.training.util.ConnectionProvider;

public class TestUserContact {

	public static void main(String[] args) 
	{
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("resources/spring.xml");
		context.registerShutdownHook();
		User user=(User)context.getBean("user");
		ConnectionProvider connectionProvider=(ConnectionProvider)context.getBean("dataSource");
		Connection connection=connectionProvider.connect();
		if(connection!=null)
		{
			System.out.println("Successfully Connected");
		}
		user.show();
	}

}
