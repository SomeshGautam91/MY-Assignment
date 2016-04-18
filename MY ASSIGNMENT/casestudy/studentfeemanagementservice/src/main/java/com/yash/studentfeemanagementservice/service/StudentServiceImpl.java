package com.yash.studentfeemanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.studentfeemanagementdao.dao.StudentDaoIfc;
import com.yash.studentfeemanagementform.form.Student;
import com.yash.studentfeemanagementlogger.logger.Log;

/**
 * 
 * @author somesh.kumar
 *This class represents student service implementation
 */

@Service
public class StudentServiceImpl implements StudentServiceIfc {

	@Autowired
	StudentDaoIfc studentDao;
	
	List<Student> listOfStudents=null;
	
	/**
	 * This method sends student model to dao for persist into database
	 * 
	 */
	public List<Student> saveStudent(Student student) {
		
		Log.getlog().info("save Student in service started");
		listOfStudents=studentDao.insertStudent(student);
		Log.getlog().info("save Student in Service end");
		return listOfStudents;
	}

	/**
	 * This method sends student Id to dao for deleting a particular Student 
	 * 
	 */

	public List<Student> deleteStudent(int index) {
		
		Log.getlog().info("deleteStudent in service started");
		listOfStudents=studentDao.deleteStudentUsingId(index);
		Log.getlog().info("deleteStudent in service end");
		return listOfStudents;
	}

	/**
	 * This method sends student model to dao for updating a particular Student 
	 * 
	 */
	public List<Student> updateStudent(Student student) {
		
		Log.getlog().info("updateStudent in service started");
		listOfStudents=studentDao.updateStudentUsingId(student);
		Log.getlog().info("updateStudent in service end");
		return listOfStudents;
	}

	/**
	 * This method sends searchdata to dao for searching
	 * 
	 */
	public List<Student> searchStudent(String searchData) {
		
		
		listOfStudents=studentDao.searchStudent(searchData);
		return listOfStudents;
	}

	/**
	 * This method search unpaid student
	 * 
	 */
	public List<Student> searchUnpaidStudent() {
		
		listOfStudents=studentDao.unpaidStudent();
		return listOfStudents;
	}

	/**
	 * This method search paid student
	 * 
	 */
	public List<Student> searchPaidStudent() {
		
		listOfStudents=studentDao.paidStudent();
		return listOfStudents;
	}

}
