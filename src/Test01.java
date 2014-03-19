
public class Test01 {
	public static void main(String[] args){
		new Wolf(5.6);
	}
}

class Creature{
	{
		System.out.println("creature non-static init!");
	}
	
	public Creature(){
		System.out.println("creature non-parameter construct fun");
	}
	
	public Creature(String name){
		this();
		System.out.println("creature construct " + name);
	}
}

class Animal extends Creature{
	{
		System.out.println("animal non-static init!");
	}
	
	public Animal(String name){
		super(name);
		System.out.println("animal construct fun " + name);
	}
	
	public Animal(String name,int age){
		this(name);
		System.out.println("animal construct "+ name + " " + age);
	}
}

class Wolf extends Animal{
	{
		System.out.println("wolf non-static init!");
	}
	public Wolf(){
		super("test",3);
		System.out.println("wolf non-parameter construct fun");
	}
	
	public Wolf(double weight){
		this();
		System.out.println("wolf constuct fun " + weight);
	}
	
}