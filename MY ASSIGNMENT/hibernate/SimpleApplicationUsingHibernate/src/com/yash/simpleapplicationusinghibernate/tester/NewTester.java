package com.yash.simpleapplicationusinghibernate.tester;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.yash.simpleapplicationusinghibernate.model.Items;
import com.yash.simpleapplicationusinghibernate.model.Labour;
import com.yash.simpleapplicationusinghibernate.model.Restaurant;

public class NewTester 
{
	public static void main(String[] args) 
	{
		AnnotationConfiguration configuration= new AnnotationConfiguration();
		SessionFactory factory=configuration.configure().buildSessionFactory();
		Session session=factory.openSession();
		
		Items item1= new Items();
		item1.setName("salad");
		
		Items item2= new Items();
		item2.setName("Drink");
		
		List<Items> items= new ArrayList<>();
		items.add(item1);
		items.add(item2);
		
		Labour labour1= new Labour();
		labour1.setName("John");
		
		Labour labour2= new Labour();
		labour2.setName("Smith");
		
		Set<Labour> labours= new HashSet<>();
		labours.add(labour1);
		labours.add(labour2);
		
		
		Restaurant rest= new Restaurant();
		rest.setName("KYRO");
		rest.setItems(items);
		rest.setLabours(labours);
		
		Transaction transaction=session.beginTransaction();
		session.save(rest);
		transaction.commit();
		session.close();
		factory.close();
		
		
	}
}
