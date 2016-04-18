package com.yash.CustomerCore.dao;

import java.util.Iterator;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.CustomerCore.form.CustomerForm;
import com.yash.CustomerCore.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDaoIfc {

	@Autowired
	SessionFactory sessionFactory;
	/*Configuration configuration= new Configuration();
	SessionFactory sessionfactory=configuration.configure().buildSessionFactory();*/
	Session session=null;
	Transaction transaction=null;
	List<Customer> customerList=null;
	
	public List<Customer> saveCustomer(Customer customer)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
		
		Session newSession=sessionFactory.openSession();
		Transaction newTransaction=newSession.beginTransaction();
		Query query=newSession.createQuery("From Customer");
		customerList=query.list();
		
		newTransaction.commit();
		newSession.close();
		Iterator<Customer> itr=customerList.iterator();
		while(itr.hasNext())
		{
			Customer customerForm1=itr.next();
			System.out.println("Name :"+customerForm1.getName()+" EmailID :"+customerForm1.getEmailId());
		}
		return customerList;
		
	
		
	}

}
