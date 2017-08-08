package com.thinkinjava.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Prac_21_5
{
	public static void main(String[] args)
	{
		ExecutorService exec=Executors.newCachedThreadPool();
		ArrayList<Future<String>> result= new ArrayList<Future<String>>();
		
		for(int i=0;i<5;i++)
		{
			result.add(exec.submit(new Fibonacci2(5)));
		}
		
		for(Future<String> fs:result)
		{
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				exec.shutdown();
			}
		}
		
		
	}
}


class Fibonacci2 implements Callable
{
	private int n;
	public Fibonacci2(int n)
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

	public String call()
	{
		// TODO Auto-generated method stub
		 System.out.println("start");
		 for (int i = 1; i <= n; i++)
		 {
	        System.out.print(fib(i) + "\t");
	     }
		 return "end";
	}
}
