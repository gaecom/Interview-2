public class TestThreadLocal {
	/*private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}*/

	public static void main(String []args){
		ThreadLocal<Thread> ttl = new ThreadLocal<Thread>();
		TestClient tc1 = new TestClient(ttl);
		TestClient tc2 = new TestClient(ttl);
		TestClient tc3 = new TestClient(ttl);
		tc1.start();
		tc2.start();
		tc3.start();
	}
}

class TestClient extends Thread {
	private static ThreadLocal<Thread> ttl ;

	public TestClient(ThreadLocal ttl) {
		this.ttl = ttl;
	}

	@Override
	public void run() {
					System.out.println("thread[" + Thread.currentThread().getName() + "]");
				//	+ "]: " + ttl.getNextNum());
			}
}
