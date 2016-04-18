package com.driver;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bean.Employee;
import com.bean.NewEmployee;

public class NewTester {

	public static void main(String[] args) {
		Resource resource= new ClassPathResource("resources/spring.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		NewEmployee employee1=(NewEmployee)factory.getBean("n1");
		NewEmployee employee2=(NewEmployee)factory.getBean("n2");
//		employee1.showEmployeeDetails();
//		System.out.println("----------------------------");
//		employee2.showEmployeeDetails();
	}

}
