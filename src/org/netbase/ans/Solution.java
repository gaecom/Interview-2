package org.netbase.ans;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findContinousSequence(20);
	}
	public static void printContinousSequence(int head,int tail){
		for(int i=head;i<=tail;i++){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void findContinousSequence(int num){
		int head = 1 ,tail = 2;
		int middle = (num + 1)/2;
		int currSum = head + tail;
		if(num <3)
			return;
		while(head<middle){
			if(currSum == num)
				printContinousSequence(head,tail);
			while(currSum >num && head<middle){
				currSum -= head;
				head++;
				if(currSum == num)
					printContinousSequence(head,tail);
			}
			tail++;
			currSum += tail;
		}
	}

}
