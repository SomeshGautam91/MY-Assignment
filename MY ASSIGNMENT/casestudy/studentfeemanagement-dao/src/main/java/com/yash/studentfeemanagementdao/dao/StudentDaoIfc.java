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
	 */
	
	public List<Student> insertStudent(Student student);

}
