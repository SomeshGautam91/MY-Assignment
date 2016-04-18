package com.deere.dsfj.jdorder.form;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * This is input form for Customer. This form will be populated only for Create
 * and Edit Customer Functionality This form bean is not used for display
 * purpose.
 */

public class CustomerForm {

	/** Id of the customer */
	private Integer number = null;

	/** Name of the customer */
	private String name = null;

	/** Address of the customer */
	private String address = null;

	/** city of the customer */
	private String city = null;

	/** country code of the customer */
	private String countryCode = null;

	/** state code of the customer */
	private String stateCode = null;

	/** name of the state */
	private String stateName = null;

	/** name of the country */
	private String countryName = null;

	/** zip code */
	private String zip = null;

	/**
	 * This variable will hold the photo customer has uploaded from create/edit
	 * customer screens
	 */
	private MultipartFile photo = null;

	/** getters and setters of the properties */
	public final Integer getNumber() {
		return number;
	}

	public final void setNumber(Integer number) {
		this.number = number;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		if (name != null) {
			this.name = name.trim();
		}
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		if (address != null) {
			this.address = address.trim();
		}
	}

	public final String getZip() {
		return zip;
	}

	public final void setZip(String zip) {
		if (zip != null) {
			this.zip = zip.trim();
		}
	}

	public final String getCountryCode() {
		return countryCode;
	}

	public final void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		if (city != null) {
			this.city = city.trim();
		}
	}

	public final String getStateCode() {
		return stateCode;
	}

	public final void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public final String getStateName() {
		return stateName;
	}

	public final void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public final String getCountryName() {
		return countryName;
	}

	public final void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public final MultipartFile getPhoto() {
		return photo;
	}

	public final void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	/**
	 * This method is used for form validations.Using Errors object provided by
	 * spring to put the validation messages.
	 */

	public void validate(Errors errors) {

		// check if name is not empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "nameEmptyOrWhiteSpace");

		// check if the name is not more than 20 characters
		if (name != null && ((name.length()) > 20)) {
			errors.rejectValue("name", "userNameLength");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "addressEmptyOrWhiteSpace");
		if (address != null && ((address.length()) > 15)) {
			errors.rejectValue("address", "addressLength");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "cityEmptyOrWhiteSpace");
		if (city != null && ((city.length()) > 15)) {
			errors.rejectValue("city", "cityLength");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "countryCodeEmptyOrWhiteSpace");
		if (countryCode != null && ((countryCode.length()) > 2)) {
			errors.rejectValue("countryCode", "countryCodeLength");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stateCode", "stateCodeEmptyOrWhiteSpace");
		if (stateCode != null && ((stateCode.length()) > 2)) {
			errors.rejectValue("stateCode", "stateCodeLength");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "zipEmptyOrWhiteSpace");
		if (zip != null && ((zip.length()) > 5)) {
			errors.rejectValue("zip", "zipLength");
		}
	}

	public String toString() {
		String newLine = "\n";
		StringBuffer buf = new StringBuffer();
		buf.append("[CustomerForm]: " + newLine);
		buf.append(" number = " + (number == null ? "[customerNumber is null]" : number.toString()) + newLine);
		buf.append(" name = " + (name == null ? "[name is null]" : "'" + name.trim() + "'") + newLine);
		buf.append(" address = " + (address == null ? "[address is null]" : "'" + address.toString() + "'") + newLine);
		buf.append(" city = " + (city == null ? "[city is null]" : "'" + city.toString() + "'") + newLine);
		buf.append(" stateCode = " + (stateCode == null ? "[stateCode is null]" : "'" + stateCode.toString() + "'")
				+ newLine);
		buf.append(" stateName = " + (stateName == null ? "[stateName is null]" : "'" + stateName.toString() + "'")
				+ newLine);
		buf.append(" zip = " + (zip == null ? "[zip is null]" : zip.toString()));
		return buf.toString();
	}
}
