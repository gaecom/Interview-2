package com.threadlocal;

import java.util.Random;

public class ThreadLocalTest implements Runnable{

	private final static ThreadLocal<Student> threadLocal = new ThreadLocal<Student>();
	
	public static void main(String[]args){
		ThreadLocalTest test = new ThreadLocalTest();
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
		System.out.println(currentThreadName + " is runging!");
		
		Random random = new Random();
		int age = random.nextInt(100);
		Student student = getStudent();
		student.setAge(age);
		System.out.println("currentThread "  + currentThreadName + " was set age to " + age );
		try{
			Thread.sleep(5000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("currentThread "  + currentThreadName + " was set age to " + age );
	}
	
	protected void setStudent(Student student){
		threadLocal.set(student);
	}
	protected Student getStudent(){
		Student s = (Student) threadLocal.get();
		if(s == null){
			s = new Student();
			threadLocal.set(s);
		}
		return s;
	}
	
}
