package com.beans;

import com.services.MessageProvider;

public class ExceptionMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		
		return "Exception Message Provider";
	}

}
