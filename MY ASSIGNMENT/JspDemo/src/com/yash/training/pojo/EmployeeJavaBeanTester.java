package com.yash.training.pojo;

public class EmployeeJavaBeanTester {

	public static void main(String [] args)
	{
		EmployeeJavaBean ejb= new EmployeeJavaBean();
		ejb.setEmpName("Somesh");
		
		System.out.println(ejb.getEmpName());
	}
}
