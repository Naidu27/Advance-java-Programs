package Jdbcconn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcex1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step-1: load the driver
		
       Class.forName("oracle.jdbc.driver.OracleDriver");
       System.out.println("Driver loaded successfully");
       // step-2: create the connection
       Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","sai","welcome");
       System.out.println("connection craeted succssfully");
       
       // step-3: static query execution
       
       Statement statement=connection.createStatement();
       
       String q1="create table emp(id number,name varchar(20),salary number)";
       
       int res1=statement.executeUpdate(q1);
       
       System.out.println("Table created successfully....."+res1);
       
       String q2="drop table emp";
       int res2=statement.executeUpdate(q2);
       
       System.out.println("Table droped successfully");
       
       //step-4: release the connection
       connection.close();
       System.out.println("connection closed succesfully");
       
       
       
	}

}
