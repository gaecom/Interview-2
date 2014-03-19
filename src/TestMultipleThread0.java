
public class TestMultipleThread0 {
	public static void main(String[] args){
		Counter counter = new Counter();
		Thread t1 = new CountThread(counter);
		Thread t2 = new CountThread(counter);
		
		t1.start();
		t2.start();
	}
}

class Counter{
	long count = 0;
	public synchronized void add(long value){
		this.count += value;
		System.out.println(Thread.currentThread().getName() + ":" + this.count);
	}
}

class CountThread extends Thread{
	protected Counter counter = null;
	
	public CountThread(Counter counter){
		this.counter = counter;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			counter.add(i);
		}
	}
	
}