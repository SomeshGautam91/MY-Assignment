package com.driver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bean.Employee;
import com.bean.NewEmployee;
import com.bean.NewUser;

public class Tester {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//find spring.xml
//		Resource resource= new ClassPathResource("resources/spring.xml");

//		//load XML into Container
//		BeanFactory factory=new XmlBeanFactory(resource);
//		
//		//Demand a Bean from Factory
//		
//		Employee e1=(Employee)factory.getBean("t");
//		Employee e2=(Employee)factory.getBean("t");
//		Employee e3=(Employee)factory.getBean("t");
//		
//		System.out.println(e1==e2);
//		System.out.println(e2==e3);
//		
//		e1.display();
//		e2.display();
//		e3.display();
		
		ApplicationContext context=new ClassPathXmlApplicationContext("resources/spring.xml");
		NewUser user=(NewUser)context.getBean("newUser");
		user.displayInfo();;

		/*Class classObj=Class.forName("com.bean.Employee");
		Constructor[] cons=classObj.getDeclaredConstructors();
	    //System.out.println(cons[0]);
		cons[0].setAccessible(true);
	    Object o=cons[0].newInstance();
	    Employee employee=(Employee)o;
        employee.display();*/
		
	}
	

}
