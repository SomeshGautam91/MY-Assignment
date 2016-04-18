package com.yash.training.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileToHashMap {

	public static void main(String [] args) throws IOException
	{
//		HashMap<String,String> mymap = new HashMap<String,String>();
		
		FileReader fr= new FileReader("WebContent/WEB-INF/properties/config.properties");
		Properties p=new Properties();
		p.load(fr);
		 
		System.out.println(p.getProperty("FirstName"));
		System.out.println(p.getProperty("LastName"));
		
//		mymap.put("First Name",p.getProperty("FirstName"));
//		mymap.put("Last Name",p.getProperty("LastName"));
	
//		for (Map.Entry<String,String> entry : mymap.entrySet()) {
//		    String key = entry.getKey();
//		    String value = entry.getValue();
//		    System.out.println(key+":"+value);
//		   
//		}
	
	}
	
		
}
