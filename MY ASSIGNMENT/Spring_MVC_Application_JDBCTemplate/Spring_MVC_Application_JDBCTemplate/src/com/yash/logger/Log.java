package com.yash.logger;

import java.util.logging.Logger;

public class Log {

	 
	public static final Logger logger=null ;
	
//	public static void createLog() throws SecurityException, IOException
//	{
//		logger=Logger.getLogger(Log.class.toString());
//		FileHandler fh=new FileHandler("D:\\log1.txt",true);
//		SimpleFormatter sm=new SimpleFormatter();
//		fh.setFormatter(sm);
//		logger.addHandler(fh);
//		
//		
//		
//	}
	
	public static Logger getlog()
	{
		return Logger.getLogger(Log.class.toString());
	}
	  
	
}
