/**
 * 
 */
package com.yash.studentfeemanagementdao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.studentfeemanagementform.form.Student;
import com.yash.studentfeemanagementlogger.logger.Log;

/**
 * @author somesh.kumar
 *
 */
@Repository
public class StudentDaoImpl implements StudentDaoIfc {

	/**
	 * 
	 * Autowiring Session Factory 
	 */
	
	@Autowired
	SessionFactory sessionFactory;
	

	
	List<Student> studentList=null;
	
	/**
	 * This method use to insert student model into database
	 */
	
	public List<Student> insertStudent(Student student) {
		
		Log.getlog().info("Insert Student in Dao started");
		
		
		
		/**
		 * open session from sessionFactory
		 */
		Session session=sessionFactory.openSession();
		
		/**
		 * begin transaction from session
		 */
		 Transaction transaction=session.beginTransaction();
		
		/**
		 * saving student model into database 
		 */
		session.save(student);
		
		/**
		 * commit transaction && close the session 
		 */
		transaction.commit();
		session.close();
		
		Log.getlog().info("Insert Student in Dao end");
		
		return getAllStudents();
		
		
	}
	
	
	/**
	 * This method use to delete student based on studentId
	 */
	
	
	public List<Student> deleteStudentUsingId(int index) {
		
		Log.getlog().info("delete Student in Dao started");
		/**
		 * open session from sessionFactory
		 */
		
		Session session=sessionFactory.openSession();
		
		/**
		 * begin transaction from session
		 */
		Transaction transaction=session.beginTransaction();
		/**
		 * creating query from session
		 */
		
		Query query=session.createQuery("Delete From Student where studentId=:id");
		query.setParameter("id",index);
		
		/**
		 * deleting data from database
		 */
		int noOfDeletedRows=query.executeUpdate();
		
		System.out.println(" deleted rows "+noOfDeletedRows);
		/**
		 * commit transaction && close the session 
		 */
		transaction.commit();
		session.close();
		
		Log.getlog().info("delete Student in Dao End");
		
		return getAllStudents();
	}
	
	/**
	 * This method use to update student based on studentId
	 */
	public List<Student> updateStudentUsingId(Student student) {
		
		Log.getlog().info("update Student in Dao started");
		
		/**
		 * open session from sessionFactory
		 */
		
		Session session=sessionFactory.openSession();
		
		/**
		 * begin transaction from session
		 */
		Transaction transaction=session.beginTransaction();
		
		/**
		 * creating query from session
		 */
		/*Query query=session.createQuery("UPDATE Student s SET s.studentName=:name,s.studentClass=:class,s.month=:month,s.paidAmount=:paidAmount,s.remainingAmount=:remainingAmount where s.studentId=:id");
		query.setParameter("name", student.getStudentName());
		query.setParameter("class", student.getStudentClass());
		query.setParameter("month", student.getMonth());
		query.setParameter("paidAmount", student.getPaidAmount());
		query.setParameter("remainingAmount", student.getRemainingAmount());
		query.setParameter("id", student.getStudentId());*/
		
		/**
		 * setting parameters into query
		 */
		
		
		/**
		 * updating data into database
		 */
		session.update(student);
		/*int result=query.executeUpdate();
		System.out.println("result updated "+result);*/
		Log.getlog().info("update Student in Dao end");
		transaction.commit();
		session.close();
		
		return getAllStudents();
	}
	
	/**
	 * This method search for a student
	 */
	
	public List<Student> searchStudent(String searchData) {
		
		/**
		 * open session from sessionFactory
		 */
		
		Session session=sessionFactory.openSession();
		
		/**
		 * begin transaction from session
		 */
		Transaction transaction=session.beginTransaction();
		
		try
		{
			int searchingStudentId=Integer.parseInt(searchData);
			int searchRemainingAmount=Integer.parseInt(searchData);
			Log.getlog().info("searchStudent in Dao started");
			
			
			/**
			 * creating query from session
			 */
			Query query=session.createQuery("from Student where studentId=:id OR remainingAmount=:id OR paidAmount=:id");
			query.setParameter("id", searchingStudentId);
			
			studentList=query.list();
			
			/**
			 * commit transaction && close the session 
			 */
			transaction.commit();
			session.close();
			
			return studentList;
			
		
		}
		catch(Exception e)
		{
			/**
			 * studentClass ,studentName and Month contains the String search data
			 */
			
			if(searchData.equals("undefined"))
			{
				System.out.println("Searchdata"+ searchData);
				studentList=getAllStudents();
			}
			else
			{
				String studentClass=searchData;
				String studentName=searchData;
				String month=searchData;
				
				Query query=session.createQuery("from Student where studentClass=:class OR studentName=:name OR month=:month");
				
				/**
				 *setting parameters into query 
				 */
				query.setParameter("class", studentClass);
				query.setParameter("name", studentName);
				query.setParameter("month", month);
				
				studentList=query.list();
			}
			
			
		
			
			/**
			 * commit transaction && close the session 
			 */
			transaction.commit();
			session.close();
			
			return studentList;
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * This method returns all students
	 */
	public List<Student> getAllStudents()
	{
		Log.getlog().info("all Student in Dao started");
		
		/**
		 * open new session from sessionFactory
		 */
		Session newSession=sessionFactory.openSession();
		
		/**
		 * begin  new transaction from session
		 */
		Transaction newTransaction=newSession.beginTransaction();
		
		/**
		 * creating query from session
		 */
		Query query=newSession.createQuery("From Student");
		
		/**
		 * fetching data from database
		 */
		studentList=query.list();
		
		/**
		 * commit transaction && close the session 
		 */
		newTransaction.commit();
		newSession.close();
		
		Log.getlog().info("all Student in Dao end");
		/**
		 * returning all students
		 */
		return studentList;
		
	}


	public List<Student> unpaidStudent() {
		
		/**
		 * open session from sessionFactory
		 */
		
		Session session=sessionFactory.openSession();
		
		/**
		 * begin transaction from session
		 */
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from Student  where remainingAmount > 0 OR paidAmount=0");
		studentList=query.list();
		
		
		/**
		 * commit transaction && close the session 
		 */
		transaction.commit();
		session.close();
		
		return studentList;
	}


	public List<Student> paidStudent() {
		
		/**
		 * open session from sessionFactory
		 */
		
		Session session=sessionFactory.openSession();
		
		/**
		 * begin transaction from session
		 */
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("from Student  where remainingAmount = 0 and paidAmount > 0 ");
		studentList=query.list();
		
		
		/**
		 * commit transaction && close the session 
		 */
		transaction.commit();
		session.close();
		
		return studentList;
		
		
	}


	

}
