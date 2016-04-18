package com.yash.inheritancewithhibernate.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.yash.inheritancewithhibernate.model.FourWheeler;
import com.yash.inheritancewithhibernate.model.TwoWheeler;

public class VehicleTester
{

	public static void main(String[] args) 
	{
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		TwoWheeler twoWheeler= new TwoWheeler();
		twoWheeler.setVehicleId(1023);
		twoWheeler.setVehicleName("TWO WHEELER");
		twoWheeler.setSteeringTwoWheeler("Simple");
		
		
		FourWheeler fourWheeler= new FourWheeler();
		fourWheeler.setVehicleId(1034);
		fourWheeler.setVehicleName("FOURWHEELER");
		fourWheeler.setSteeringFourWheeler("POWER STEERING");
		
		
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}

}
