
public class Test04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	private static void test1() {
		// TODO Auto-generated method stub
		String s1 = "疯狂java";
		String s2 = "疯狂" + "java";
		System.out.println("s1:" + s1.hashCode());
		System.out.println("s2:" + s2.hashCode());
		System.out.println(s1 == s2);
		
		final String str1 = "疯狂";
		final String str2 = "java";
		String s3 = str1 + str2;
		System.out.println("str1:" + str1.hashCode());
		System.out.println("str2:" + str2.hashCode());
		System.out.println("s3:" + s3.hashCode());
		
		System.out.println(s1 == s3);
	}

}
