package com.bean;

public class FourWheeler extends Vehicle {
	
	private int length;
	private int width;
	private int seatingCapacity;
	private String steringType;
	
	public FourWheeler(long vehicleNo, String manufacturer, int length,
			int width, int seatingCapacity, String steringType) {
		super(vehicleNo, manufacturer);
		this.length = length;
		this.width = width;
		this.seatingCapacity = seatingCapacity;
		this.steringType = steringType;
	}
	
	public long getVehicleNo()
	{
		return vehicleNo;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public String getSteringType() {
		return steringType;
	}
	public void setSteringType(String steringType) {
		this.steringType = steringType;
	}
	
	
	

}
