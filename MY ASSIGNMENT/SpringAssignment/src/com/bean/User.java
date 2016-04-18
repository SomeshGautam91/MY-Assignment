package com.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class User
{
	private int userId;
	private String name;
	private Contact contact;
	private String email;
	private Set<Address> addressList;
	private Map<String,Vehicle> vehicles;
	private Address permAddress;
	/*private Address permAddress;
	private Address corpAddress;
	
	
	

	public Address getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(Address permAddress) {
		this.permAddress = permAddress;
	}

	public Address getCorpAddress() {
		return corpAddress;
	}

	public void setCorpAddress(Address corpAddress) {
		this.corpAddress = corpAddress;
	}
*/
	public User(int userId, String name, Contact contact, String email) 
	{
		super();
		this.userId = userId;
		this.name = name;
		this.contact = contact;
		this.email = email;
		
	}
	
	public User()
	{
	
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}

	public Map<String,Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Map<String,Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void showUserDetails()
	{
		System.out.println("UserId:"+getUserId());
		System.out.println("Name:"+getName());
		System.out.println("Email:"+getEmail());
		System.out.println("---------User Contact Info-------------");
		System.out.println("ContactId:"+getContact().getContactId());
		System.out.println("ContactName:"+getContact().getContactName());
		System.out.println("Phone No.:"+getContact().getPhone());
		
		System.out.println("---------User Address Info-------------");
		
		for(Address address:addressList)
		{
			
			System.out.println("House No "+address.getHouseNo());
			System.out.println("Street "+address.getStreet());
			System.out.println("City "+address.getCity());
		}
		
		Set<Entry<String,Vehicle>> vehicleSet=vehicles.entrySet();  
	    Iterator<Entry<String,Vehicle>> itr=vehicleSet.iterator();  
	    while(itr.hasNext()){  
	        Entry<String,Vehicle> entry=itr.next();   
	        Vehicle vehicle=entry.getValue();
	        
	        if(vehicle instanceof TwoWheeler)
			{
				
				System.out.println("---------User Two Wheeler Vehicle Info-------------");
				System.out.println("Vehicle No "+ ((TwoWheeler)vehicle).getVehicleNo() );
				System.out.println("Manufacturer "+ ((TwoWheeler)vehicle).getManufacturer() );
				System.out.println("FrontBreak"+ ((TwoWheeler)vehicle).getFrontBreak() );
				System.out.println("RearBreak "+ ((TwoWheeler)vehicle).getRearBreak() );
				System.out.println("FuelTankCapacity "+ ((TwoWheeler)vehicle).getFuelTankCapacity() );
				System.out.println("BatteryCompany "+ ((TwoWheeler)vehicle).getBatteryCompany() );
			}
			else
			{
				System.out.println("---------User Four Wheeler Vehicle Info-------------");
				System.out.println("Vehicle No "+ ((FourWheeler)vehicle).getVehicleNo() );
				System.out.println("Manufacturer "+ ((FourWheeler)vehicle).getManufacturer() );
				System.out.println("Length "+ ((FourWheeler)vehicle).getLength() );
				System.out.println("Width "+ ((FourWheeler)vehicle).getWidth() );
				System.out.println("SeatingCapacity "+ ((FourWheeler)vehicle).getSeatingCapacity());
				System.out.println("SteringType "+ ((FourWheeler)vehicle).getSteringType());
			}
	        
	    }  
		
		/*for(Vehicle vehicle:vehicles)
		{
			if(vehicle instanceof TwoWheeler)
			{
				
				System.out.println("---------User Two Wheeler Vehicle Info-------------");
				System.out.println("Vehicle No "+ ((TwoWheeler)vehicle).getVehicleNo() );
				System.out.println("Manufacturer "+ ((TwoWheeler)vehicle).getManufacturer() );
				System.out.println("FrontBreak"+ ((TwoWheeler)vehicle).getFrontBreak() );
				System.out.println("RearBreak "+ ((TwoWheeler)vehicle).getRearBreak() );
				System.out.println("FuelTankCapacity "+ ((TwoWheeler)vehicle).getFuelTankCapacity() );
				System.out.println("BatteryCompany "+ ((TwoWheeler)vehicle).getBatteryCompany() );
			}
			else
			{
				System.out.println("---------User Four Wheeler Vehicle Info-------------");
				System.out.println("Vehicle No "+ ((FourWheeler)vehicle).getVehicleNo() );
				System.out.println("Manufacturer "+ ((FourWheeler)vehicle).getManufacturer() );
				System.out.println("Length "+ ((FourWheeler)vehicle).getLength() );
				System.out.println("Width "+ ((FourWheeler)vehicle).getWidth() );
				System.out.println("SeatingCapacity "+ ((FourWheeler)vehicle).getSeatingCapacity());
				System.out.println("SteringType "+ ((FourWheeler)vehicle).getSteringType());
			}
		}
		*/
		
		
		
	}
	


	
	
}
