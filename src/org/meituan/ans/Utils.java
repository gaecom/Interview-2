package org.meituan.ans;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	private static Map<String,Integer> departmentTable = new HashMap<String,Integer>();
	private static Map<String,Integer> areaTable = new HashMap<String,Integer>();
	
	static{
		departmentTable.put("sales", 4);
		departmentTable.put("technology", 3);
		departmentTable.put("finance", 2);
		departmentTable.put("hr", 1);
		areaTable.put("huabei", 0);
		areaTable.put("huadong",1);
		areaTable.put("huanan",2);
		areaTable.put("huazhong",3);
		areaTable.put("xinan",4);
		areaTable.put("xibei",5);
		areaTable.put("dongbei", 6);
	}
	public static String getCode(String department,String area){
		StringBuilder sb = new StringBuilder();
		sb.append(departmentTable.get(department)).append(areaTable.get(area));
		
		return sb.toString();
	}
}
