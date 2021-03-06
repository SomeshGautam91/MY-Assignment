package com.yash.studentfeemanagementform.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author somesh.kumar This class represents Student form
 *
 */
@Entity
@Table(name="student")
public class Student {

	/**
	 * Student Id
	 */
	@Id 
	private int studentId;



	/**
	 * Student Name
	 */
	
	private String studentName;

	/**
	 * Student Class
	 */
	private String studentClass;
	
	/**
	 * fee submit date
	 */
	
	private String month;
	
	/**
	 * Amount submit
	 */
	
	private int paidAmount;
	
	/**
	 * 
	 * remaining Amount 
	 */
	private int remainingAmount;

	/**
	 * @return student id Student id getter method
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            Student Id setter method
	 */

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return student name Student name getter method
	 */

	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            Student Name setter method
	 */

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return student class Student class getter method
	 */

	public String getStudentClass() {
		return studentClass;
	}

	/**
	 * @param studentClass
	 *            Student Class setter method
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	
	/**
	 * 
	 * @return month of fee submission
	 */
	
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 * month setter method
	 */
	
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return paid amount
	 */
	
	
	public int getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount
	 * paid amount setter method
	 */
	
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return remaining Amount
	 */
	
	public int getRemainingAmount() {
		return remainingAmount;
	}

	/**
	 * @param remainingAmount
	 * remaining amount setter method
	 */
	
	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	

}
