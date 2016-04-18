package com.beans;

import com.services.MessageProvider;
import com.services.MessageRenderer;

public class Tester {

	public static void main(String[] args) {
		
		MessageProvider msp = new ErrorMessageProviderImpl(); 
		MessageRenderer msr = new StandardOutMsgRendererImpl();
		msr.setMessageProvider(msp);
		msr.getMessageRenderer();
		
		

	}

}
