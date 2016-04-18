package com.yash.hibernatespringintegrationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yash.hibernatespringintegrationapp.dao.EmployeeDaoIfc;
import com.yash.hibernatespringintegrationapp.pojo.Employee;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class EmployeeServiceImpl implements EmployeeServiceIfc {

	@Autowired
	public EmployeeDaoIfc employeeDaoIfc;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	public void saveEmployee(Employee employee) {
		
		employeeDaoIfc.saveEmployee(employee);
	}

}
