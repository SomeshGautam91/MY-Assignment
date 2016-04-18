package com.yash.simpleapplicationusinghibernate.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yash.simpleapplicationusinghibernate.model.Book;
import com.yash.simpleapplicationusinghibernate.model.Certificates;
import com.yash.simpleapplicationusinghibernate.model.Student;
import com.yash.simpleapplicationusinghibernate.model.StudentAddress;

public class BookTester
{
	public static void main(String[] args)
	{
		Configuration configuration= new Configuration();
		
		SessionFactory factory=configuration.configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		Book book=new Book();
		book.setName("New World");
		book.setAuthor("Somesh");
		
		Book book1=new Book();
		book1.setName("New Universe");
		book1.setAuthor("Somesh");
		
		Book book2=new Book();
		book2.setName(" World");
		book2.setAuthor("Somesh");
		
		Book book3=new Book();
		book3.setName("Universe");
		book3.setAuthor("Somesh");
		
		
		Set<Book> bookSet= new HashSet<>();
		bookSet.add(book);
		bookSet.add(book1);
		
		Set<Book> bookSet1= new HashSet<>();
		bookSet1.add(book2);
		bookSet1.add(book3);
		
		Certificates javaCertificate=new Certificates();
		javaCertificate.setName("Java");
		
		Certificates sqlCertificate=new Certificates();
		sqlCertificate.setName("SQL");
		
		List<Certificates> certificates1= new ArrayList<>();
		certificates1.add(javaCertificate);
		certificates1.add(sqlCertificate);
		
		List<Certificates> certificates2= new ArrayList<>();
		certificates2.add(javaCertificate);
		certificates2.add(sqlCertificate);
		
		StudentAddress studentPermAddress= new StudentAddress();
		studentPermAddress.setCity("Meerut");
		studentPermAddress.setState("U.P");
		studentPermAddress.setZip(250001);
		
		StudentAddress studentTempAddress= new StudentAddress();
		studentTempAddress.setCity("Indore");
		studentTempAddress.setState("M.P");
		studentTempAddress.setZip(452001);
		
		
		Map<String,StudentAddress> map=new HashMap<>();
		map.put("PermAddress",studentPermAddress);
		map.put("TempAddress",studentTempAddress);
		
		Map<String,StudentAddress> map1=new HashMap<>();
		map1.put("PermAddress",studentPermAddress);
		map1.put("TempAddress",studentTempAddress);
		
		
		Map<String,StudentAddress> map2=new HashMap<>();
		map2.put("PermAddress",studentPermAddress);
		map2.put("TempAddress",studentTempAddress);
		
		
		Student student1= new Student();
		student1.setName("Akshay");
		student1.setBooks(bookSet);
		student1.setCertificates(certificates1);
		student1.setStudentAddress(map);
		
		Student student2= new Student();
		student2.setName("Jack");
		student2.setBooks(bookSet1);
		student2.setCertificates(certificates2);
		student1.setStudentAddress(map1);
		
		
		Student student3= new Student();
		student2.setName("John");
		student2.setBooks(bookSet1);
		student2.setCertificates(certificates2);
		student1.setStudentAddress(map2);
		
		
//		Student student1= new Student();
//		student1.setName("Pra");
//		student1.setBooks(bookSet1);
		
		Transaction transaction=session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		//session.save(student1);
		transaction.commit();
		
		
		
	}
}
