package com.beans;


import com.services.MessageProvider;
import com.services.MessageRenderer;

public class FileMsgRendererImpl implements MessageRenderer {
	
	private MessageProvider msp=null;
	
	
	public void setMessageProvider(MessageProvider msp)
	{
		this.msp=msp;
	}
	

	@Override
	public MessageProvider getMessageRenderer() 
	{
		return msp;
		
		
	}

	

}
