package com.yash.hibernatewithmaven.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AppTester 
{
	 
	public static void main(String[] args) 
	{

			AnnotationConfiguration annotationConfiguration= new AnnotationConfiguration();
			
			SessionFactory sessionFactory=annotationConfiguration.configure().buildSessionFactory();
				
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
				
				
				User user= new User();
				user.setName("Somesh");
				user.setAddress(address);
				user.setVehicle(vehicle);

				
				User newCustomer=(User) session.load(User.class,new Integer(1));
				System.out.println("Customer ID---"+newCustomer.getId());
				System.out.println("Customer Name--"+newCustomer.getName());
				System.out.println("Customer City--"+newCustomer.getAddress().getCity());
				System.out.println("Customer State--"+newCustomer.getAddress().getState());
				System.out.println("Customer Zip--"+newCustomer.getAddress().getZip());
				System.out.println("Vehicle type--"+newCustomer.getVehicle().getType());
				System.out.println("Vehicle RegistrationCity--"+newCustomer.getVehicle().getRegistration().getRegistrationCity());
				System.out.println("Vehicle RegistrationState--"+newCustomer.getVehicle().getRegistration().getRegistrationState());
				
				Transaction transaction=session.beginTransaction();
				
				session.save(user);
				
				transaction.commit();
				
				session.close();
				
				sessionFactory.close();
				
				

	}

}
