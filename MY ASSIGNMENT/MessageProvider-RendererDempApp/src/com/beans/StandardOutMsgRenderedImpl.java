package com.beans;

import com.services.MessageProvider;
import com.services.MessageRenderer;
public class StandardOutMsgRenderedImpl implements MessageRenderer {

	private MessageProvider messageProvider;

	@Override
	public void renderer() {
		if( messageProvider==null)
		{
			throw  new RuntimeException("NO PROVIDER fOUND");
		}
		System.out.println( messageProvider.getMessage());
		
		
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this. messageProvider= messageProvider;
		
	}

	@Override
	public MessageProvider getMessageProvider() {
		
		return  messageProvider;
	}

}
