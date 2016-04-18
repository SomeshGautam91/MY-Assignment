package com.yash.simpleapplicationusinghibernate.tester;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;






import com.yash.simpleapplicationusinghibernate.model.College;
import com.yash.simpleapplicationusinghibernate.model.CollegeStudent;

public class CollegeTester 
{
	
	public static void main(String[] args) 
	{
		
			AnnotationConfiguration configuration= new AnnotationConfiguration();
			SessionFactory factory=configuration.configure().buildSessionFactory();
			Session session=factory.openSession();
			
			CollegeStudent student1= new CollegeStudent();
			student1.setStudentId(101);
			student1.setName("Somesh");
			
			CollegeStudent student2= new CollegeStudent();
			student1.setStudentId(102);
			student2.setName("Pradeep");
			
			
			Set<CollegeStudent> studentSet1= new HashSet<>();
			studentSet1.add(student1);
			
			Set<CollegeStudent> studentSet2= new HashSet<>();
			studentSet2.add(student2);
			
			
			College college1= new College();
			college1.setCollegeName("IMS Engineering College");
			college1.setStudents(studentSet1);
			
			
			
			College college2= new College();
			college2.setCollegeName("AKG Engineering college");
			college2.setStudents(studentSet2);
			
			
			Transaction transaction=session.beginTransaction();
			
			session.save(college1);
			session.save(college2);

			transaction.commit();
			session.close();
			factory.close();
	}

}
