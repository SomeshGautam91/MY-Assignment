package com.yash.inheritancewithhibernate.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.yash.inheritancewithhibernate.model.Employee;
import com.yash.inheritancewithhibernate.model.HourlyEmployee;
import com.yash.inheritancewithhibernate.model.SalaryEmployee;

public class EmployeeTester 
{

	public static void main(String[] args) 
	{
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		HourlyEmployee hourlyEmployee= new HourlyEmployee();//transient Object
		hourlyEmployee.setName("Harsh");
		hourlyEmployee.setHours_Of_Day(10f);
		hourlyEmployee.setPer_Hour_Pay(1000);
		
		
		SalaryEmployee salaryEmployee= new SalaryEmployee();//transient Object
		salaryEmployee.setName("Kapil");
		salaryEmployee.setAnnual_Salary(250000);
		
		
		
	/*	session.save(hourlyEmployee);//persistent Object
		session.save(salaryEmployee);//persistent Object
		
		hourlyEmployee.setName("Neha");*/
		
		
		
		transaction.commit();
		
		session.close();
		
		
		Session newSession=sessionFactory.openSession();
		
		Transaction newTransaction=newSession.beginTransaction();
		
		SalaryEmployee newSalaryEmployee=(SalaryEmployee)newSession.load(SalaryEmployee.class,new Integer(2));
		
		//newSession.update(salaryEmployee);
		
		System.out.println("Employee ID "+ newSalaryEmployee.getEmpId());
		System.out.println("Employee Name "+ newSalaryEmployee.getName());
		System.out.println("Employee Annual Salary "+ newSalaryEmployee.getAnnual_Salary());
		
		newTransaction.commit();
		
		newSession.close();
		
		
		
		

	}

}
