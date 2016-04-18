package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.beans.StandardOutMsgRenderedImpl;



public class SpringTester {

	public static void main(String[] args) {
		Resource resource= new ClassPathResource("resources/spring.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		StandardOutMsgRenderedImpl smp=(StandardOutMsgRenderedImpl) factory.getBean("SOM");
		smp.renderer();
	}

}
