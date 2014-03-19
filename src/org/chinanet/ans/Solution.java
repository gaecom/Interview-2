package org.chinanet.ans;

public class Solution {

	/**
	 * @param args
	 */
	private static byte[] queues = new byte[8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			queues[i] = 1;
		}
		queue(0);
		for(int i = 0;i<8;i++){
			System.out.println(queues[i]);
		}
	}

	private static void queue(int num) {
		// TODO Auto-generated method stub

		if(num == 8)return;
		for(int t=0;t<8;t++){
			queues[t] = (byte) (Math.pow(2,7-t));
			if(isOk(t) == 1)
				queue(t+1);
		}

	}

	private static int isOk(int n) {
		// TODO Auto-generated method stub
		for (int j = 0; j < n; j++) {
			int result1 = Math.max(queues[j], queues[n]) / Math.min(queues[j], queues[n]);
			int result2 = Math.abs(n - j);
			if (result1 == 1) {
				return 0;
			} else if (result1 == result2) {
				return 0;
			}
		}
		return 1;
	}

}
