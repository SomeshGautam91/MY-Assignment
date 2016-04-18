package com.yash.training.thread;

public class TestMyThread {

	public static void main(String[] args) {
		myThread my=new myThread();
		Thread t1=new Thread(my);
		Thread t2=new Thread(my);
		Thread t3=new Thread(my);
		t1.setName("Fact");
		t2.setName("Arms");
		t3.setName("Prime");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
