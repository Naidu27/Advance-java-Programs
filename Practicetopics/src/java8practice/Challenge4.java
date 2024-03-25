package java8practice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class country{
	
	String name;
	long population;
	String currency;
	String capital;
	int states;
	public country(String name, long population, String currency, String capital, int states) {
		super();
		this.name = name;
		this.population = population;
		this.currency = currency;
		this.capital = capital;
		this.states = states;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return "country [name=" + name + ", population=" + population + ", currency=" + currency + ", capital="
				+ capital + ", states=" + states + "]";
	}
	
	
}

public class Challenge4 {

	public static void main(String[] args) {
		
		List<country>l=new LinkedList<country>();
		
		l.add(new country("India",1380004385,"INR","Delhi",28));
		l.add(new country("United States",331002651,"USD","Washington",50));
		l.add(new country("China",1444216107,"CNY","Beijing",23));
		l.add(new country("Brazil",212559417,"BRL","Braslia",26));
		l.add(new country("Austrralia",25499884,"AUD","Canberra",8));
		l.add(new country("SouthAfrica",59308690,"ZAR","Pretoria",9));
		
		//l.stream().map(p->p.getName()).forEach(System.out::println);
		//l.stream().map(p->p.getName() +" ------"+p.getPopulation()).forEach(System.out::println);
        
	  //  l.stream().filter(p->p.getPopulation ()>100000). map(p->p.getPopulation() * 1.06).forEach(System.out::println);
		
	///	l.stream().filter(p->p.getStates()<10).map(p->{p.setStates(p.getStates()+5);return p;}).forEach(System.out::println);
		
	//	Optional<long>m=l.max((p1,p2)->p1.getPopulation Compareto p2.getPopulation);
	//	System.out.println(m.orElse(null));
		
		
		}

}
