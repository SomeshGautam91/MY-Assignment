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

/**
 * @author somesh.kumar
 *
 */
@Repository
public class StudentDaoImpl implements StudentDaoIfc {

	@Autowired
	SessionFactory sessionFactory;
	
	Session session=null;
	Transaction transaction=null;
	List<Student> studentList=null;
	
	/**
	 * This method use to insert student model into database
	 */
	
	public List<Student> insertStudent(Student student) {
		
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		
		
		Session newSession=sessionFactory.openSession();
		Transaction newTransaction=newSession.beginTransaction();
		Query query=newSession.createQuery("From Student");
		studentList=query.list();
		newTransaction.commit();
		newSession.close();
		
		return studentList;
	}

}
