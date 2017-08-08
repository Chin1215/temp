package com.thinkinjava.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Prac_21_6
{
	public static void main(String[] args)
	{
		ExecutorService  exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
		{
			exec.execute(new SleepTask(i));
		}
		exec.shutdown();
	}
}


class SleepTask implements Runnable
{
	private int n;
	public SleepTask(int n)
	{
		this.n=n;
	}
	public void run()
	{
		// TODO Auto-generated method stub
		Random rd=new Random();
		int a=rd.nextInt(10)+1;
		try {
			TimeUnit.MILLISECONDS.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Interrupted "+a+" MILLISECONDS");
		}finally{
			System.out.println("Task : "+n+" Interrupted "+a+" MILLISECONDS");
		}
	}
	
}
