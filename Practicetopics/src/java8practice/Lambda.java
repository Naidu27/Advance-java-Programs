package java8practice;

interface hello{
	public void say();
}

public class Lambda {

	public static void main(String[] args) {
	
		String s="sai";
		
		hello h=()->{
			System.out.println("hello"+"  "+s);
		};
		
		h.say();
	}

}
