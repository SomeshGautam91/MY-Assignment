package com.yash.studentfeemanagementservice.service;

import java.util.List;

import com.yash.studentfeemanagementform.form.Student;

/**
 * @author somesh.kumar
 *This interface represents student service
 */

public interface StudentServiceIfc {
	
	/**
	 * @param student
	 * @return list of student
	 * 
	 */
	public List<Student> saveStudent(Student student);
	
	/**
	 * 
	 * @param index
	 * @return list of student after deletion
	 */
	public List<Student> deleteStudent(int index);
	
	/**
	 * 
	 * @param student
	 * @return list of student after updation 
	 */
	
	public List<Student> updateStudent(Student student);
	
	/**
	 * 
	 * @param searchData
	 * @return list of student after search
	 */
	public List<Student> searchStudent(String searchData);
	
	public List<Student> searchUnpaidStudent();
	
	public List<Student> searchPaidStudent();
	

}
