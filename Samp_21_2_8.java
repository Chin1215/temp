package com.thinkinjava.thread;

import java.util.concurrent.TimeUnit;

public class Samp_21_2_8 
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread daemon=new Thread(new SimpleDaemons());
		daemon.setDaemon(true);
		daemon.start();
		System.out.println("daemon started");
		TimeUnit.MILLISECONDS.sleep(4000);
	}
}


class SimpleDaemons implements Runnable
{
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				TimeUnit.MILLISECONDS.sleep(3000);
				System.out.println("still running!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("sleep interrupted");
			}
		}
	}
	
}
