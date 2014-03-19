package org.brion.ans;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(1,2);
		Circle c = new Circle(1,2,3);
		Circle c1 = new Circle(1,2,4);
		
	//	System.out.println(p.equals(c));
		boolean result = false;
		result = c.equals(p);
		System.out.println(result);
	//	System.out.println(c.equals(c1));
	}

}
