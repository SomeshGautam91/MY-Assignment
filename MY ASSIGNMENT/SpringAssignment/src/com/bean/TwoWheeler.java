package com.bean;

public class TwoWheeler extends Vehicle {

	private  int frontBreak;
	private int rearBreak;
	private int fuelTankCapacity;
	private String batteryCompany;
	
	public TwoWheeler(long vehicleNo, String manufacturer, int frontBreak,
						int rearBreak, int fuelTankCapacity, String batteryCompany) {
		super(vehicleNo, manufacturer);
		this.frontBreak = frontBreak;
		this.rearBreak = rearBreak;
		this.fuelTankCapacity = fuelTankCapacity;
		this.batteryCompany = batteryCompany;
	}

	public long getVehicleNo()
	{
		return vehicleNo;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public int getFrontBreak() {
		return frontBreak;
	}

	public void setFrontBreak(int frontBreak) {
		this.frontBreak = frontBreak;
	}

	public int getRearBreak() {
		return rearBreak;
	}

	public void setRearBreak(int rearBreak) {
		this.rearBreak = rearBreak;
	}

	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(int fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public String getBatteryCompany() {
		return batteryCompany;
	}

	public void setBatteryCompany(String batteryCompany) {
		this.batteryCompany = batteryCompany;
	}
	
	
	
	
	 
	

}
