package com.beans;

import com.services.MessageProvider;

public class ErrorMessageProviderImpl implements MessageProvider {

	@Override
	public String getMessage() {
		
		return "Error Message";
	}

}
