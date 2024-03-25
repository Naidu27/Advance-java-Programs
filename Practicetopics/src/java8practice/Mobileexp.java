package java8practice;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class mobile
{
	String name;
	String color;
	int price;
	public Object mobilename;
	
	public mobile(String name, String color, int price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "mobile [name=" + name + ", color=" + color + ", price=" + price + "]";
	}
	
	}

public class Mobileexp {

	public static void main(String[] args) {
		
		List <mobile>l=new ArrayList <mobile>();
		l.add(new mobile("apple13","pink",78000));
		l.add(new mobile("oneplus9","Aurora green",750000));
		l.add(new mobile("apple10","silver",90000));
		l.add(new mobile("OppoF19","CosmicBlack",85000));
		l.add(new mobile("OppoF17","Gold",90000));
		l.add(new mobile("readmi","red",15000));
		l.add(new mobile("realme","Blue",12000));
		l.add(new mobile("vivo","Blue",22000));
		
		//l.stream().filter(p->p.getName().contains("apple")).forEach(System.out::println);
  //  l.stream().filter(p->p.price>1000).forEach(System.out::println);
	//	l.stream().filter(p->p.color.equals("red")&p.price>5000).forEach(System.out::println);
	//	Set <mobile> mobile=l.stream().filter(p->p.color.equals("Blue")& p.price <50000).collect(Collectors.toSet());
	//	System.out.println(mobile);
		
	//	List<mobile> mobile=l.stream().filter(p->p.color.equals("red")).collect(Collectors.toList());
	//	System.out.println(mobile);
		
	//	l.stream().filter(p->p.getName().contains("vivo")).limit(1).forEach(System.out::println);
		
	//	l.stream().filter(p->p.getName().contains("Oppo")).skip(1).limit(1).forEach(System.out::println);

	/*	List<mobile>m=l.stream().filter(p->p.getName().contains("realme")).collect(Collectors.toList());
		
       if(m.size()!=0)
       {
    	   System.out.println(m);
    	   
       }
       else
       {
    	   System.out.println("no mobile");
       }*/
		
	//	System.out.println(l.stream().filter(p->p.getName().contains("apple")).count());
		
		
		
		
	}

}
