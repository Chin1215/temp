package com.thinkinjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Samp_21_3_1
{
	public static void main(String[] args)
	{
		EvenChecker.test(new EvenGenerator());
	}
}

class EvenChecker implements Runnable
{
	private IntGenerator generator;
	private final int id;
	private EvenChecker(IntGenerator g,int ident)
	{
		generator=g;
		id=ident;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(!generator.isCanceled())
		{
			int val=generator.next();
			if(val%2!=0)
			{
				System.out.println(val+"not even!");
				generator.cancel();
			}
		}
		
	}
	
	public static void test(IntGenerator gp,int count)
	{
		System.out.println("press ctrl+c to exit");
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<count;i++)
		{
			exec.execute(new EvenChecker(gp,i));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator gp)
	{
		test(gp,10);
	}
	
}

abstract class IntGenerator
{
	private volatile boolean canceled=false;
	public abstract int next();
	public void cancel()
	{
		canceled=true;
	}
	public boolean isCanceled()
	{
		return canceled;
	}
}


class EvenGenerator extends IntGenerator
{
	private int currentEvenValue=0;
	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}
	
}




