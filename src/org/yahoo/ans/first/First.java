package org.yahoo.ans.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
/*
 * 题目大意：Q1:找出在两个整数相除得到的小数中指定整数D第M次出现的位置。
 * 例如：A B M D A=3 B=7 M=2 D=4 A/B=0.428571428……
 * 答案为 7
 *  
 */
public class First {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File input = new File(
					"F:/ThinkPad E420/Codes/Java/indigows/FileDemo/src/org/yahoo/ans/first/data.txt");

			BufferedReader br = new BufferedReader(new FileReader(input));
			String lineNumber = br.readLine();
			String lineData;
			int lineCount = 0;
			while ((lineData = br.readLine()) != null) {
				lineCount++;
				String[] dataArray = lineData.split(" ");
				for (int i = 0; i < dataArray.length; i++) {
					System.out.print(dataArray[i] + ",");
				}

				int a = Integer.parseInt(dataArray[0]);
				int b = Integer.parseInt(dataArray[1]);
				int count = Integer.parseInt(dataArray[2]);
				int digit = Integer.parseInt(dataArray[3]);

				HashMap<Integer, Integer> digitMap = new HashMap<Integer, Integer>();

				int e, f;
				e = a % b;
				int total = 0;
				boolean noResult = false;
				while (true) {
					e = e % b;
					if (e == 0) {
						noResult = true;
						break;
					}
					e = e * 10;
					f = e / b;
					total++;
					if (f == digit) {
						count--;
						if (count == 0) {
							break;
						}
					}
					if (digitMap.get(e) == null) {
						digitMap.put(e, count);
					} else {
						Integer lastCount = digitMap.get(e);
						if (lastCount == count) {
							System.out.print("  No result, e:" + e + ",f:" + f
									+ ",last count:" + lastCount + ",count:"
									+ count + "   ");
							noResult = true;
							break;
						}
						digitMap.put(e, count);
					}
					System.out.print(f);
				}//end while
				if (noResult) {
					System.out.println("," + 0);
				} else {
					System.out.println("," + total);
				}

				if (lineCount == 15)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
