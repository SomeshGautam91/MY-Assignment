package com.yash.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTag extends TagSupport 
{
	
	public int doStartTag()
	{
		JspWriter out=pageContext.getOut();
		try {
			out.println("<Font color='red'>*</Font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
