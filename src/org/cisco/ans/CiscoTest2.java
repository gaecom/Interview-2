package org.cisco.ans;

public class CiscoTest2 extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CiscoTest2 c = new CiscoTest2();
		
		System.out.println(c.getClass().getSimpleName() + " " + c.getSuperClass() );
	}

	public void run(){
		
	}
	
	public String getSuperClass(){
		System.out.println(super.toString());
		System.out.println(super.getClass().getName());
		return super.getClass().getSimpleName();
	}
}
