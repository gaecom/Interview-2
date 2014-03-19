
public class Test05 {
	public static void main(String[]args){
		/*int count = 0;
		for(int i=0;i<10;i++){
			count = count++; //count++
		}
		System.out.println("count=" + count);*/
		
		Test05 test = new Test05();
		int i = 140;
		test.f((long) i);
		//test.f(Integer.valueOf(i));
	}
	
	/*public void f(long a){
		System.out.println("基本类型的方法被调用");
	}*/
	
	public void f(Long a){
		System.out.println("包装类型的方法被调用");
	}
}
