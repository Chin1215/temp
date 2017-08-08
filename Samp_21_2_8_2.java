package com.thinkinjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Samp_21_2_8_2
{
	public static void main(String[] args) throws InterruptedException 
	{
		ExecutorService exec=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++)
		{
			exec.execute(new DaemonFromFactory());
		}
		System.out.println("all thread started");
		TimeUnit.MILLISECONDS.sleep(100);
	}
}

class DaemonThreadFactory implements ThreadFactory
{

	public Thread newThread(Runnable arg0) {
		// TODO Auto-generated method stub 
		Thread thread=new Thread(arg0);
		thread.setDaemon(true);
		return thread;
	}
	
}

class DaemonFromFactory implements Runnable
{
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" : "+this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("interrupted");
			}
		}
	}
	
}
