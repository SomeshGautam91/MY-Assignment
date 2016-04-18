package com.yash.training.driver;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yash.training.beans.SimpleBean;

public class SimpleBeanTester {

	public static void main(String[] args)
	{
		//Finding xml
		ConfigurableApplicationContext context=new ClassPathXmlApplicationContext();
		
		//getting configurable Bean Factory object
		context.refresh();
		ConfigurableListableBeanFactory factory=context.getBeanFactory();
		
		//registering user bean into bean factory container
		factory.registerSingleton("simpleBean",new SimpleBean());
		
		//geeting bean from  container
		SimpleBean sBean=(SimpleBean)context.getBean("simpleBean");
		
		sBean.show();
	}

}
