package org.amazon.ans.first;

import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		if(size % 2 != 1)
			throw new RuntimeException("the size is not right!");
		
		for(int i = 0 ;i<size;i++){
			for( int j = 0;j<size;j++){
				int number = getNumber(size,i,j);
				String end = null;
				if(j == (size - 1)){
					end = "" ;
				}else end = "*";
				
				System.out.print(number + end);
			}
			System.out.println();
		}*/
		System.out.println(clockwise(5));
		
	}

	private static int getNumber(int size, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i + j <= (size -1)){  
			int index = Math.min(i, j);
			int temp = (size - 2*index)*(size - 2*index) - (size - 2*index -1);
			if(i == j){
				return temp;
			}else {
				return temp + j - i;
			}		
		}else {
			int xx =  size - 1 - i;
			int yy =  size - 1  - j;
			int index = Math.min(xx, yy);
			int temp = (size - 2*index) * (size - 2*index) - 3 *(size - 2*index - 1);
			if( xx == yy ){
				return temp;
			}else{
				return temp + yy - xx;
			}
		}
	}

	
	static String clockwise(int size){
		StringBuffer sb = new StringBuffer();
		if(size % 2 != 1)
			throw new RuntimeException("the size is not right!");
		
		for(int i = 0 ;i<size;i++){
			for( int j = 0;j<size;j++){
				int number = getNumber(size,i,j);
				String end = null;
				if(j == (size - 1)){
					end = "" ;
				}else end = "*";
				
				sb.append(number + end);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
