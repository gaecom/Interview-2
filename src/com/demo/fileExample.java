package com.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class fileExample {
	public static void main(String[] args) throws FileNotFoundException {
		// file url : C:\Work\apache-jmeter-2.7\bin\OrionTestParam.csv
		String fileName = "C:" + File.separator + "Work" + File.separator
				+ "apache-jmeter-2.7" + File.separator + "bin" + File.separator
				+ "OrionTest_sp1_300_.csv";
		File f = new File(fileName);
		Integer SSeq = 1;

		String FileUrl = "ftp://10.224.37.252/spare/Orion/";
		Integer caseId = 200000000;
		String orionTestParam = null;
		try {
			Writer out = new FileWriter(f);
			for (int j = 0; j < 300; j++) {
				String sSSeq = (SSeq++).toString();
				String sCaseId = (caseId++).toString();
				if (j < 60) {
					orionTestParam = sSSeq + "," + FileUrl + sCaseId + "/"
							+ "," + sCaseId + "," + "13499182" + "\n";
				} else if (j < 120) {
					orionTestParam = sSSeq + "," + FileUrl + sCaseId + "/"
							+ "," + sCaseId + "," + "13499182" + "\n";
				} else if (j < 180) {
					orionTestParam = sSSeq + "," + FileUrl + sCaseId + "/"
							+ "," + sCaseId + "," + "17401771" + "\n";
				} else if (j < 240) {
					orionTestParam = sSSeq + "," + FileUrl + sCaseId + "/"
							+ "," + sCaseId + "," + "17401771" + "\n";
				} else {
					orionTestParam = sSSeq + "," + FileUrl + sCaseId + "/"
							+ "," + sCaseId + "," + "17223779" + "\n";
				}
				out.write(orionTestParam);
			}
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
