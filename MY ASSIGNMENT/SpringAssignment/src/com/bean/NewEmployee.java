package com.bean;

public class NewEmployee {
	
	private long empId;
	private String empName;
	private Vehicle vehicle;
	
	public NewEmployee(long empId, String empName, Vehicle vehicle)
	{
		
		this.empId = empId;
		this.empName = empName;
		this.vehicle = vehicle;
	}
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
//	public void showEmployeeDetails()
//	{
//		System.out.println("Employee Id "+ getEmpId());
//		System.out.println("Employee Name "+ getEmpName());
//		System.out.println("Employee Vehicle No "+getVehicle().getVehicleNo());
//		System.out.println("Vehicle Manufacturer "+getVehicle().getManufacturer());
//		System.out.println("Vehicle Color "+getVehicle().getColor());
//		System.out.println("Employee Vehicle No "+getVehicle().getComponent().getBodyManufacturer());
//		System.out.println("Employee Vehicle No "+getVehicle().getComponent().getGlassManufacturer());
//		System.out.println("Employee Vehicle No "+getVehicle().getComponent().getTyreManufacturer());
//	}
	

}
