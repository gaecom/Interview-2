package org.cisco.ans;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomTest extends Thread{
	
	public static void main(String[] args){
		ExecutorService  es = Executors.newFixedThreadPool(3);
		for(int j=1;j<5;j++){
			final int taskId = j;
			es.execute(new Runnable(){
				public void run(){
					for(int i=1;i<3;i++){
						System.out.print(taskId + "" + i + " ");
					}
				}
			});
		}
		es.shutdown();
	}
}
