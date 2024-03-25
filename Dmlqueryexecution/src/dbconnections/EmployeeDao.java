package dbconnections;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public int save(Employee emp) throws Throwable
	{
		// Declare the resources
		Connection connection=null;
		
		PreparedStatement PreparedStatement=null;
		int count=0;
		
		try {
			// get the connection
			connection = Dbconnection.CreateConnection();
			// create the ps object
			
			PreparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			// read the data from emp object and set to parameters
			
			PreparedStatement.setInt(1, emp.getEmpId());
			PreparedStatement.setString(2,emp.getEmpName());
			PreparedStatement.setDouble(3, emp.getEmpsalary());
			
			count=PreparedStatement.executeUpdate();
		
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		finally {
			//before release connection chech the connectio 
			
			if(connection!=null)
				connection.close();
			if(PreparedStatement!=null)
				PreparedStatement.close();
		}
		return count;
	}

	public Employee findById(int empid) throws SQLException
	{
		Employee employee=null;
		// try-with resources 
		try(Connection connection=Dbconnection.CreateConnection();
	
				PreparedStatement preparedstatement=connection.prepareStatement("select * from where empid=?");
				)
				{
					preparedstatement.setInt(1, empid);
					ResultSet resultset=preparedstatement.executeQuery();
					
					if(resultset.next()) {
						employee=new Employee();
						employee.setEmpId(resultset.getInt(1));
						employee.setEmpName(resultset.getString(2));
						employee.setEmpsalary(resultset.getDouble(3));
						
					}
				}
				catch(SQLException e)
		{
					e.printStackTrace();
		}
		return employee;
	}
	
	public int deleteById(int empId)
	{
		int count=0;
		
		try(Connection connection=Dbconnection.CreateConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empId=?");
				
				){
					preparedStatement.setInt(1,empId);
					count=preparedStatement.executeUpdate();
					
				}
				catch(SQLException e)
		{
					e.printStackTrace();
		}
		return count;
		
	}
	
	public int deleteBysalary(double empsalary)
	{
		int count=0;
		try(Connection connection=Dbconnection.CreateConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empsalary>=?");
				)
				{
					preparedStatement.setDouble(1,empsalary);
					count=preparedStatement.executeUpdate();
				}
				
				catch(SQLException e)
				{
					e.printStackTrace();
				}
		return count;
	}
		
	public List<Employee> findAll(){
		
		List<Employee>emp=new ArrayList<Employee>();
		try(Connection connection=Dbconnection.CreateConnection();
				Statement statement=connection.createStatement())
		{
			ResultSet resultset=statement.executeQuery("select * from emp");
			
			 Employee employee=new Employee();
			while(resultset.next())
			{
				employee.setEmpId(resultset.getInt(1));
				employee.setEmpName(resultset.getString(2));
				employee.setEmpsalary(resultset.getDouble(3));
				emp.add(employee);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		    return emp;
		
}


/* int updatesalary(double currentsalary , double incsalary) {
		
	try(Connection connection=Dbconnection.CreateConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("update emp set empsalary=empsalary+?where salary>?"))
				{
					preparedStatement.setDouble(1, (double)Employee.getempsalary());
				}
		
		return 0;
	}*/
	 
}
