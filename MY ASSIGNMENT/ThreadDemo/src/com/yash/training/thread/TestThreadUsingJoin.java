package com.yash.training.thread;

public class TestThreadUsingJoin {

	public static void main(String[] args) {
		MyThreadUsingJoin t1= new MyThreadUsingJoin();
		MyThreadUsingJoin t2= new MyThreadUsingJoin();
		MyThreadUsingJoin t3= new MyThreadUsingJoin();
		
		t1.setName("first");
		t2.setName("Second");
		t3.setName("Third");
		
		t1.start();
		try 
		{
			t1.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		t2.start();
		t3.start();

	}

}
