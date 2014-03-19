package org.rakuten.ans;

public class DemoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,-5,2,4,-2};
		int index = equi(a);
		System.out.println("the index is " + index);
		int indexo = equio(a);
		System.out.println("the indexo is " + indexo);
	}

	private static int equi(int[] a) {
		// TODO Auto-generated method stub
		//O(n)
		int rightSum = 0,leftSum = 0;
		for(int i=0;i<a.length;i++){
			rightSum +=a[i];
		}
		System.out.println("sum is " + rightSum);
		for(int j=0;j<a.length;j++){
			rightSum = rightSum - a[j];
			System.out.println("j=" +j + "  leftSum=" + leftSum + "  rightSum="+ rightSum );
			if(leftSum == rightSum)
				return j;
			leftSum += a[j];
		}
		return -1;
	}
	
	private static int equio(int[] a ){
		//O(n^2)
		int lSum ,rSum;
		for(int i=0;i<a.length;++i){
			lSum = 0;rSum = 0;
			for(int j=0;j<i;++j)
				lSum += a[j];
			for(int j=i+1;j<a.length;++j){
				rSum += a[j];
			}
		//	System.out.println("i=" + i + " lSum=" + lSum + " rSum=" + rSum);
			if(lSum == rSum)
				return i;
		}
		
		return -1;
	}

}
