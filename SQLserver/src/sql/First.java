package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class First {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/sai ","root","root");

		System.out.println("connection created successfully");
		
	//	PreparedStatement preparedStatement=connection.prepareStatement("create table emp(empid number,empname varchar(20),empsalary float");
		
	//	System.out.println("table created ");
		
		PreparedStatement preparedStatement2=connection.prepareStatement("insert into emp(values=?,?,?)");
		
		preparedStatement2.setInt(1, 111);
		preparedStatement2.setString(2, "sai");
		preparedStatement2.setFloat(3,3999);
		
		preparedStatement2.setInt(1, 222);
		preparedStatement2.setString(2, "sree");
		preparedStatement2.setFloat(3,4999);
		
		preparedStatement2.setInt(1, 333);
		preparedStatement2.setString(2, "mahi");
		preparedStatement2.setFloat(3,5999);
		
		preparedStatement2.addBatch();
		
		preparedStatement2.executeUpdate();
		
		System.out.println("created ");
	
		connection.close();
	}

	
}
