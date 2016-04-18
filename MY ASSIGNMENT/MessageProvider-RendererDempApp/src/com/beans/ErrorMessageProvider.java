package com.beans;

import com.services.MessageProvider;

public class ErrorMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		
		return "Error Message Provider";
	}

}
