package com.ajaxtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajaxtest.model.Employee;
import com.ajaxtest.util.DBUtil;

public class EmployeeDao {
	
private Connection connection;
	
	public EmployeeDao() {
		connection = DBUtil.getConnection();
	}
	
	public List<Employee> getEmployeeList(){
		
		List<Employee> employeeList= new ArrayList<Employee>();
		
		try {
			Statement stmnt= connection.createStatement();
			ResultSet rs= stmnt.executeQuery("SELECT * FROM empl_mast");
			while(rs.next()){
				Employee empl= new Employee();
				empl.setEmp_id(rs.getInt("emp_id"));
				empl.setEmp_name(rs.getString("emp_name"));
				empl.setEmp_loc(rs.getString("emp_loc"));
				empl.setEmp_desig(rs.getString("emp_desig"));
				empl.setEmp_depart(rs.getString("emp_depart"));
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}
	
public List<Employee> searchEmployee(String str){
		
		List<Employee> employeeList= new ArrayList<Employee>();
		
		try {
			Statement stmnt= connection.createStatement();
			ResultSet rs= stmnt.executeQuery("SELECT * FROM empl_mast where emp_name like '"+str+"%'");
			while(rs.next()){
				Employee empl= new Employee();
				empl.setEmp_id(rs.getInt("emp_id"));
				empl.setEmp_name(rs.getString("emp_name"));
				empl.setEmp_loc(rs.getString("emp_loc"));
				empl.setEmp_desig(rs.getString("emp_desig"));
				empl.setEmp_depart(rs.getString("emp_depart"));
				employeeList.add(empl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}
	
	public void addEmployee(Employee employee){
		try {
			PreparedStatement ps=connection.prepareCall("INSERT INTO empl_mast(emp_id, emp_name, emp_loc, emp_desig,emp_depart) VALUES (?,?,?,?,?)");
			ps.setInt(1, employee.getEmp_id());
			ps.setString(2, employee.getEmp_name());
			ps.setString(3, employee.getEmp_loc());
			ps.setString(4, employee.getEmp_desig());
			ps.setString(5, employee.getEmp_depart());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteEmployee(String eId){
		try {
			PreparedStatement ps= connection.prepareStatement("DELETE FROM empl_mast WHERE emp_id="+eId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee employee){
		try {
			PreparedStatement ps=connection.prepareCall("UPDATE empl_mast SET emp_name=?,emp_loc=?,emp_desig=?,emp_depart=?WHERE emp_id=?");
			ps.setString(1, employee.getEmp_name());
			ps.setString(2, employee.getEmp_loc());
			ps.setString(3, employee.getEmp_desig());
			ps.setString(4, employee.getEmp_depart());
			ps.setInt(5, employee.getEmp_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
