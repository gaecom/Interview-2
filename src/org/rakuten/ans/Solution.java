package org.rakuten.ans;

public class Solution {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		int K = -4, L = 1, M = 2, N = 6, P = 0, Q = -1, R = 4, S = 3;
		int sum = solution(K, L, M, N, P, Q, R, S);
		System.out.println("sum is " + sum);
	}

	private static int solution(int k, int l, int m, int n, int p, int q,
			int r, int s)  {
		try {
			if ((k >= m && l >= n) || (p >= r && q >= s))
				throw new Exception("invalid parameters!");
			int leftX = Math.min(k, p);
			int rightX = Math.max(m, r);
			int upY = Math.max(s, n);
			int downY = Math.min(q, l);

			int distanceX = rightX - leftX;
			int distanceY = upY - downY;

			int rectAWidth = m - k;
			int rectAHeight = n - l;
			int rectBWidth = r - p;
			int rectBHeight = s - q;
			if ((distanceX >= (rectAWidth + rectBWidth))
					|| (distanceY >= (rectAHeight + rectBHeight))) {
				return rectAWidth * rectAHeight + rectBWidth * rectBHeight;
			} else if (distanceX < Math.max(rectAWidth, rectBWidth)
					&& distanceY < Math.max(rectAHeight, rectBHeight)) {
				return Math.max(rectAWidth * rectAHeight, rectBWidth
						* rectBHeight);
			} else {
				int tempX = rectAWidth + rectBWidth - distanceX;
				int tempY = rectAHeight + rectBHeight - distanceY;
				return rectAWidth * rectAHeight + rectBWidth * rectBHeight
						- tempX * tempY;
			}
		} catch (Exception e) {
			return -1;
		}
	}

}
