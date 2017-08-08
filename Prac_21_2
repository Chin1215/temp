package com.thinkinjava.thread;

public class Prac_21_2 
{
	public static void main(String[] args) 
	{
		Fibonacci task1=new Fibonacci(5);
		Thread t1=new Thread(task1);
		
		Fibonacci task2=new Fibonacci(6);
		Thread t2=new Thread(task2);
		
		
		t1.start();
		t2.start();
	}
}


class Fibonacci implements Runnable
{
	private int n;
	public Fibonacci(int n)
	{
		this.n=n;
	}
	
	public int fib(int n)
	{
		if(n==1||n==2)
			return n-1;
		else
			return fib(n-1)+fib(n-2);
	}

	public void run()
	{
		// TODO Auto-generated method stub
		 System.out.println("strat");
		 for (int i = 1; i <= n; i++)
		 {
	        System.out.print(fib(i) + "\t");
	     }
		 System.out.println("end");
	}
}
