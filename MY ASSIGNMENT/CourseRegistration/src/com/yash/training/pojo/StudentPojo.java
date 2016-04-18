package com.yash.training.pojo;

public class StudentPojo {
	
	private String courseName;
	private Long contact;
	private String name;
	private String gender;
	private String startDate;
	private String preferredBatch;
	private String desc;
	
	
	
	public StudentPojo(String courseName, Long contact, String name,
			String gender, String startDate, String preferredBatch, String desc) {
		super();
		this.courseName = courseName;
		this.contact = contact;
		this.name = name;
		this.gender = gender;
		this.startDate = startDate;
		this.preferredBatch = preferredBatch;
		this.desc = desc;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getPreferredBatch() {
		return preferredBatch;
	}
	public void setPreferredBatch(String preferredBatch) {
		this.preferredBatch = preferredBatch;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
