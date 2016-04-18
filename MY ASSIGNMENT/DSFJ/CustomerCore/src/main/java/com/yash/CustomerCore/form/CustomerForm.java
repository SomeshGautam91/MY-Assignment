package com.yash.CustomerCore.form;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class CustomerForm {

	private int id;
	private String name;
	private String emailId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void validation(Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","nameContaineWhiteSpaceorEmpty");
		
		if(name!=null && name.length() > 10)
		{
			errors.rejectValue("name", "nameLength");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"emailId","emailContaineWhiteSpaceorEmpty");
		
		
	}
	
	
}
