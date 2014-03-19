
public class TestPrivate {

	/**
	 * @param args
	 */
	private int x;
	protected int y;
	int z;
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPrivate tp = new TestPrivate();
		for(int i=0;i<args.length;i++){
			System.out.print(" " + args[i]);
		}
		System.out.println();
	System.out.println(args[0]);
	}*/
	
	public static void main(String[ ] args){
		int i = 10;
		int j = 5;
		i = i++%j;
		System.out.println("i=" + i);
	}

}

