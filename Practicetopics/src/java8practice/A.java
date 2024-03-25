package java8practice;

 interface Greeting{
	 void greet(String name);
 }
 
public class A {

	public static void main(String[] args) {
		Greeting g=(name)->{
	 System.out.println("hello"+" "+name);
	};
	g.greet("sai");
	}
}
