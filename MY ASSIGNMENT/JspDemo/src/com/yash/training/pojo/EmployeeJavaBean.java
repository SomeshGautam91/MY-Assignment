package com.yash.training.pojo;

import java.io.Serializable;

public class EmployeeJavaBean implements Serializable  {
	
	private int empId;
	private String empName;
	
	public EmployeeJavaBean()
	{
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
}
