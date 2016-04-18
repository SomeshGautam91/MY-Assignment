package com.yash.simplemavenapplication.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.simplemavenapplication.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDaoIfc {

	@Autowired
	SessionFactory sessionFactory;
	/*Configuration configuration= new Configuration();
	SessionFactory sessionfactory=configuration.configure().buildSessionFactory();*/
	
	@Override
	public void saveCustomer(Customer customer)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
		
	}

}
