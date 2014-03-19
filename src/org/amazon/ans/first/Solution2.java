package org.amazon.ans.first;

public class Solution2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hadoop in practice";
		String str2 = "Hadoop operations";
		int index = differ(str1,str2);
		System.out.println(index);
		
	}

	static int differ(String string1, String string2) {
		// TODO Auto-generated method stub
		int sum,i = 0,j=0;
		
		String[] str1 = string1.split("\\s");
		String[] str2 = string2.split("\\s");
		int length1 = str1.length;
		int length2 = str2.length;
		int len = Math.max(length1,length2);
		sum = len;
		while (i < length1) {
			while(j < length2 ) {
				if(str1[i].equals(str2[j])){
					//System.out.println("string1["+ i + "]:" + string1[i]);
					//System.out.println("string2["+ j + "]:" + string2[j]);
					i++;
					j++;
					sum = sum - 1 ;
					
					//System.out.println("sum:" + sum);
				
				}else{
					j++;
				}
			}
			i++;
		}
		return sum;
	}

}
