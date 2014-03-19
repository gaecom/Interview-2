
public class TestFinally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(test());
	}

	private static int test() {
		// TODO Auto-generated method stub
		int i = 0;
		try{
			i = i+ 100;
			return i;
		}finally{
			System.out.println("before: " + i);
			i = i + 20;
			System.out.println("after:" + i);
			System.out.println("finally block");
		}
	}

}
