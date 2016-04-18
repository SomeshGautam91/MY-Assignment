package com.bean;

public class Contact 
{
	private int contactId;
	private String contactName;
	private long phone;
	
	public Contact(int contactId, String contactName, long phone) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.phone = phone;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
