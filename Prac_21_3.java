package com.thinkinjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Prac_21_3
{
	public static void main(String[] args)
	{
		ExecutorService exec;
//		exec=Executors.newCachedThreadPool();
//		for(int i=0;i<5;i++)
//		{
//			exec.execute(new Print("task start","task end"));
//		}
		//exec.shutdown();
//		System.out.println("***********************************************");
		//ScheduledExecutorService ss=new ScheduledThreadPoolExecutor(5);
		
		exec=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
		{
			exec.execute(new Print("task start","task end"));
		}
		exec.shutdown();
		System.out.println("***********************************************");
		
		
//		exec=Executors.newSingleThreadExecutor();
//		for(int i=0;i<5;i++)
//		{
//			exec.execute(new Print("task start","task end"));
//		}
		//exec.shutdown();
//		System.out.println("***********************************************");
	}
}
