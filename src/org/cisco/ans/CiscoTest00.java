package org.cisco.ans;

public class CiscoTest00 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s = new Derived();
		s.addFive();
		System.out.println(s.n + " " + s.getValue());
	}

}

class Super{
	 int n;
	
	public Super(){
		n =3;
	}
	public void addFive(){
		n +=5;
	}
	
	public int getValue(){
		return n;
	}
}

class Derived extends Super{
	 int n;
	public Derived(){
		n= 8 ;
	}
	
	public void addFive(){
		this.n += 5;
	}
	
	public int getValue(){
		return n;
	}
}