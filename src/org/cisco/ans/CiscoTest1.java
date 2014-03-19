package org.cisco.ans;

public class CiscoTest1 extends Thread {
	public volatile String  name = "hi";

	public void startThread(String str) {
		name = name + str;
		System.out.println(name.hashCode());
		start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			name = name + " " + i;
		}
		System.out.println(Thread.currentThread().getName().toString() + ":" + name);
		System.out.println(name.hashCode());
	}
	
	public static void main(String [] args){
		
		CiscoTest1 c = new CiscoTest1();
		System.out.println(c.getState());
		c.startThread(" cisco");
		System.out.println(c.getState());
		
		System.out.println(c.name);
	}
}
