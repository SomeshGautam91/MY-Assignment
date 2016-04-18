package com.yash.training.thread;

public class MyThreadUsingJoin extends Thread{
	
	
	public void run()
	{
		for(int i=1;i<6;i++)
		{
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
			try 
			{
				Thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				
				e.printStackTrace();
			}
		}
	}

}
