package com.yash.hibernatespringintegrationapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.yash.hibernatespringintegrationapp.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoIfc {

	@Autowired
	public SessionFactory sessionFactory;
	
	
	@Override
	public void saveEmployee(Employee employee) 
	{
		/*System.out.println(employee.getName());
		Transaction transaction=getSession().beginTransaction();
		getSession().save(employee);
		transaction.commit();
		getSession().close();*/
		sessionFactory.getCurrentSession().save(employee);

	}
	
	/*public Session getSession()
	{
		Session session=sessionFactory.openSession();
		return session;
		
	}*/
	
	
}
