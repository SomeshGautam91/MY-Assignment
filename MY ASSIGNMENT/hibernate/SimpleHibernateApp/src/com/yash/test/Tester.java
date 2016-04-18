package com.yash.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.yash.pojo.UserDetails;

public class Tester 
{

	public static void main(String[] args)
	{
		
		Date date = null;
		AnnotationConfiguration configuartion=new AnnotationConfiguration();
		SessionFactory factory=configuartion.configure().buildSessionFactory();
		Session session=factory.openSession();
		
		String dateofBirth="1990/08/09";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		
		try 
		{
			date = new java.sql.Date(format.parse(dateofBirth).getTime());
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		UserDetails user= new UserDetails();
		user.setName("Somesh");
		user.setContact(123456789);
		user.setAddress("Ganga Nagar");
		user.setStatus(true);
		user.setDateOfBirth(date);
		user.setShortDescription("Working in Yash Technology as a trainee programmer");
		
		Transaction transaction=session.beginTransaction();
		
		session.save(user);
		
		transaction.commit();
		session.close();
		factory.close();

	}

}
