package com.test;

import com.beans.ExceptionMessageProvider;
import com.beans.StandardOutMsgRenderedImpl;
import com.services.MessageProvider;
import com.services.MessageRenderer;

public class Tester {

	public static void main(String[] args) {
		MessageProvider mp= new ExceptionMessageProvider();
		MessageRenderer mr= new StandardOutMsgRenderedImpl();
		mr.setMessageProvider(mp);
		mr.renderer();

	}

}
