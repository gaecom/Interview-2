
public class Test03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Wolf1("gray",32.3));
	}

	
	
}

class Animal1{
	private String desc;
	public Animal1(){
		this.desc  = getDesc();
	}
	public String getDesc(){
		return "Animal"	;
	}
	public String toString(){
		return desc;
	}
}

class Wolf1 extends Animal1{
	private String name;
	private double weight;
	public Wolf1(String name,double weight){
		this.name = name;
		this.weight = weight;
	}
	public String getDesc(){
		return "wolf[name="+name +",weight=" + weight + "]";
	}
}