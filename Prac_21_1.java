package com.thinkinjava.thread;

public class Prac_21_1
{
	public static void main(String[] args)
	{
		Print task1=new Print("task start","task end");
		Thread t1=new Thread(task1);
		Print task2=new Print("task start","task end");
		Thread t2=new Thread(task2);
		Print task3=new Print("task start","task end");
		Thread t3=new Thread(task3);
		t1.start();
		t2.start();
		t3.start();
	}
}

class Print implements Runnable
{
	private String start;
	private String end;
	public Print(String start,String end)
	{
		this.start=start;
		this.end=end;
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(start);
		for(int i=0;i<3;i++)
		{
			System.out.println("current : "+i);
			Thread.yield();
		}
		System.out.println(end);
	}
	
}
