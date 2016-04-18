package com.deere.dsfj.jdorder.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.dao.CustomerDao;
import com.deere.dsfj.jdorder.domain.Customer;

/**
 * 
 * @author dinesh.kumar
 *
 */
@Repository(value="customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer findById(Integer customerId) {
		Session session = sessionFactory.openSession();
		Customer customer= (Customer) session.get(Customer.class,customerId);
		System.out.println(customer.getState()+ " name of contry" );
		
		session.close();
		return customer;
	}
	
	@Override
	public void add(Customer customer) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);

		transaction.commit();
	}

	@Override
	public List<Customer> findByName(String name) {
		//use createQuery method to build the search  query. Use createQuery method when you want to build the search query for search criteria apart from primary field
		Session session = sessionFactory.openSession();
		System.out.println("dao called for search customer");
    	Query query =  session.createQuery("from Customer c where c.name like :name");
        query.setParameter("name", (name + "%"));
        return query.list();
	}

}
