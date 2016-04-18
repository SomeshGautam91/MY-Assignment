package com.yash.training.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User 
{
	@Size(min=2,max=20)
	@NotNull
	private String name;
	private Long contact;
	private String email;
	private Date dob;
	private String[] skillSets;
	private Address userAddress;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String[] getSkillSets() {
		return skillSets;
	}
	public void setSkillSets(String[] skillSets) {
		this.skillSets = skillSets;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	
}
