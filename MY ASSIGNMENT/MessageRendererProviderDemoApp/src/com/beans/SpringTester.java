package com.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.services.MessageRenderer;

public class SpringTester {

	public static void main(String[] args) {
		Resource resource= new ClassPathResource("resources/spring.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		MessageRenderer mr=(StandardOutMsgRendererImpl)factory.getBean("smr");
		mr.getMessageRenderer();

	}

}
