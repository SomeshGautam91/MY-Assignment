package com.yash.training.thread;

public class myThread implements Runnable {

	@Override
	public void run() {
		Thread ct=Thread.currentThread();
		int n;
		int r;
		int sum;
		boolean bl;
		if(ct.getName().equals("Fact"))
		{
			for(int i=1;i<15;i++)
			{
				long f=fact(i);
				System.out.println("Factorial of "+i+"is"+f);
			}
			
		}
		else if(ct.getName().equals("Prime"))
		{
			for(int j=3;j<1000;j++)
			{
				bl=prime(j);
				if(bl==true)
				{
					System.out.println("prime Number");
					System.out.println(j);
				}
			}
		}
		else
		{
			
			for(int k=1;k<1000;k++)
			{
				sum=0;
				n=k;
				while(n!=0)
				{
					r=n%10;
					n=n/10;
					sum+=r*r*r;
				}
				if(sum==k)
				{
					System.out.println("Armstrong No.");
					System.out.println(k);
					
				}
			}
			
		}
	}
	public int fact(int n)
	{
		if(n==0 || n==1)
			return n;
		else
			return (n*fact(n-1));
	}
	
	public boolean prime(int p)
	{
		int j=2;
		boolean b=false;
		while(j<p)
		{
			if(p%j==0)
			{
				return b;
			}
			else
			{
				j++;
			}
		
		
		}
		if(j==p)
		{
			b=true;
			return b;
		}
		return b;
		
	}
}
