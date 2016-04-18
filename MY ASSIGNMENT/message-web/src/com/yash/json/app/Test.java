package com.yash.json.app;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yash.json.form.Customer;

public class Test {
	
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setCity("New Delhi");
		customer.setId(1008);
		customer.setName("Mike");
	
		Customer customer1 = new Customer();
		customer1.setCity("New York");
		customer1.setId(1009);
		customer1.setName("Jack");
		
		List<Customer>customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		
		
		Gson gson = new Gson();
		gson.toJson(customer);
		String jsonFormate=gson.toJson(customers);
		
		System.out.println("Object in its real format" + customer);
		System.out.println("Object in JSON format" + jsonFormate);
		
	}

}
