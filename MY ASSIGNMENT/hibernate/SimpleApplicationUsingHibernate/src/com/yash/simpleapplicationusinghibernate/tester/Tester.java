package com.yash.simpleapplicationusinghibernate.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yash.simpleapplicationusinghibernate.model.Address;
import com.yash.simpleapplicationusinghibernate.model.Customer;
import com.yash.simpleapplicationusinghibernate.model.Registration;
import com.yash.simpleapplicationusinghibernate.model.Vehicle;

public class Tester 
{

	public static void main(String[] args) 
	{
		//to load and read configuration file
		Configuration configuration= new Configuration(); 
		
		//to connnect with database
		SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		
		
		Registration registration= new Registration();
		registration.setRegistrationCity("Indore");
		registration.setRegistrationState("M.P");
		registration.setSeriesNo(9545);
		
		Vehicle vehicle=new Vehicle();
		vehicle.setType("FourWheeler");
		vehicle.setRegistration(registration);
	
		
		Address address= new Address();
		address.setCity("Meerut");
		address.setState("U.P");
		address.setZip("250001");
		
		
		Customer customer= new Customer();
		customer.setName("Somesh");
		customer.setAddress(address);
		customer.setVehicle(vehicle);

		
		
		
		
		
		
		Customer newCustomer=(Customer) session.load(Customer.class,new Integer(1));
		System.out.println("Customer ID---"+newCustomer.getId());
		System.out.println("Customer Name--"+newCustomer.getName());
		System.out.println("Customer City--"+newCustomer.getAddress().getCity());
		System.out.println("Customer State--"+newCustomer.getAddress().getState());
		System.out.println("Customer Zip--"+newCustomer.getAddress().getZip());
		System.out.println("Vehicle type--"+newCustomer.getVehicle().getType());
		System.out.println("Vehicle RegistrationCity--"+newCustomer.getVehicle().getRegistration().getRegistrationCity());
		System.out.println("Vehicle RegistrationState--"+newCustomer.getVehicle().getRegistration().getRegistrationState());
		
		Transaction transaction=session.beginTransaction();
		
		session.save(customer);
		
		transaction.commit();
		
		
		
		

	}

}
