package org.meituan.ans;

public class CountUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDao();
		int count = ud.getUserCount("getUserCount/sales/huadong/hefei");
		System.out.println("count:" + count);
	}

}
