
public class Test06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str1 = null;
		str1 = new String[]{"aa","bb"};
		
		String[] str2 = new String[]{"aa","bb"};
		
		String[] str3 = {"aa","bb"};
		
		String[] str4 = new String[4];
		
		int num = 2; //0000 0000 0000 0000 0000 0000 0000 0010
		num = num<<63;//31 00011111  32 00100000 63 00111111
		System.out.println(num);
		
	}

}
