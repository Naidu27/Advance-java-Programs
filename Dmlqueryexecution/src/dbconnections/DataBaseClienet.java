package dbconnections;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class DataBaseClienet {

	public static void main(String[] args) throws Throwable {
	
		EmployeeDao employeedao=new EmployeeDao();
		int res1=employeedao.save(new Employee(1001,"sam",1000.00) );
		System.out.println("data sucessfulyy---- "+res1);

		int res2=employeedao.save(new Employee(1002,"jam",2000.00) );
		System.out.println("data sucessfully------"+res2);
		
	/*	Employee emp=new Employee();
		Employee  emp1=employeedao.findById(1001);
		System.out.println(emp1);*/
		
		/*int deletecount=employeedao.deleteById(1001);
		if(deletecount!=0)
			System.out.println("deletion sucessfull---"+deletecount);
		else
			System.out.println("deletion not done---"+deletecount);*/
		
		/*int deletecount=employeedao.deleteBysalary(500.05);
		if(deletecount>0)
			System.out.println("delete sucessfull---"+deletecount);
		else
			System.out.println("deletion not done---"+deletecount);	*/
		
	List<Employee> emp=employeedao.findAll();
	emp.forEach(System.out::println);
	}

}
