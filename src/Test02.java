
public class Test02 {
	public static void main(String[] args){
		new Derived();
	}
}

class Base{
	private int i=2;
	public Base(){
		this.display();
	}
	
	public void display(){
		System.out.println(i);
	}
}

class Derived extends Base{
	private int i= 22;
	public Derived(){
		i =222;
	}
	public void display(){
		System.out.println(i);
	}
}
