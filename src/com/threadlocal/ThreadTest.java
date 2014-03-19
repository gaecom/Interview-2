package com.threadlocal;

import java.util.Random;

public class ThreadTest implements Runnable{
	
	private Student student = new Student();
	ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest test = new ThreadTest();
		Thread t1 = new Thread(test,"a");
		Thread t2 = new Thread(test,"b");
		t1.start();
		t2.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		accessStudent();
	}


	private void accessStudent() {
		// TODO Auto-generated method stub
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println(currentThreadName + " is running!");
		Random random = new Random();
		int age = random.nextInt(100);
		this.student.setAge(age);
		System.out.println("currentThread: " + currentThreadName + " was set age to " + age);
		try{
			Thread.sleep(5000);
			
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		System.out.println("currentThread: " + currentThreadName + " was set age to " + age);
	}

}
