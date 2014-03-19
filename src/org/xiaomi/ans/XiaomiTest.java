package org.xiaomi.ans;
public class XiaomiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int result = CircleMatrix(n, i, j);
				String end = null;
				if (j == (n - 1)) {
					end = "\n";
				} else
					end = " ";
				sb.append(result + end);
			}
		}
		System.out.println(sb.toString());
	}

	private static int CircleMatrix(int n, int i, int j) {
		// TODO Auto-generated method stub
		int sum = i + j;
		int temp = 0;
		if (sum % 2 == 0) {
			temp = 0;
			if (sum <= n - 1) {
				for (int r = 0; r <= sum + 1; r++) {
					temp += r; // (0,sum) = temp;
				}
				return temp -(sum -j);
			}else{
				temp = (n+1)*n/2;
				for(int r=n;r<sum+1;r++){
					temp += 2*n -1 -r;
				}
				return temp - ( n-1-j);
			}
		} else {
			temp = 0;
			if (sum <= n - 1) {
				for (int r = 0; r <= sum + 1; r++) {
					temp += r; // (sum,0) = temp; 
				}
				return temp -j;
			}else{
				temp = (1+n)*n/2;
				for(int r =n;r<sum+1;r++){
					temp += 2*n -1-r;  
				}
				return temp - ( n-1-i);
			}
		}

	}

}
