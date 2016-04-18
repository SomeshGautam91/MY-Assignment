/**
 * 
 */
package com.yash.studentfeemanagementdao.dao;

import java.util.List;

import com.yash.studentfeemanagementform.form.Student;

/**
 * @author somesh.kumar
 * This interface represents student dao 
 *
 */
public interface StudentDaoIfc {
	
	/**
	 * @param student
	 * @return list of student
	 *
	 */
	
	public List<Student> insertStudent(Student student);
	
	/**
	 * 
	 * @param index
	 * @return list of student
	 */
	
	public List<Student> deleteStudentUsingId(int index);
	
	/**
	 * 
	 * @param student
	 * @return list of student
	 */
	
	public List<Student> updateStudentUsingId(Student student);
	
	/**
	 * @param searchData
	 * @return list of students
	 */
	
	public List<Student> searchStudent(String searchData);
	
	/**
	 * 
	 * @return list of students
	 */
	public List<Student> unpaidStudent();
	
	/**
	 * 
	 * @return list of students
	 */
	public List<Student> paidStudent();

}
