package com.yash.inheritancewithhibernate.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.yash.inheritancewithhibernate.model.Circle;
import com.yash.inheritancewithhibernate.model.Rectangle;

public class ShapeTester 
{

	public static void main(String[] args) 
	{
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Rectangle rectangle= new Rectangle();
		rectangle.setShapeName("RECTANGLE");
		rectangle.setLength(2.5f);
		rectangle.setBreadth(3.5f);
		
		
		Circle circle= new Circle();
		circle.setShapeName("CIRCLE");
		circle.setCircleRadius(3.14f);
		
		
		session.save(rectangle);
		session.save(circle);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
