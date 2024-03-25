package Batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batchex1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","sai","welcome");
		
		Statement statement= connection.createStatement();
		
		statement.addBatch("create table stu(id number,name varchar2(20))");
		statement.addBatch("insert into stu values (111,'ratan')");
		statement.addBatch("insert into stu values (222,'ram')");
		statement.addBatch("delete from stu where id in(111,222)");
		statement.addBatch("drop table stu");
		
		int [] results=statement.executeBatch();
		for(int result : results) {
			System.out.println(result);
		}
		
		connection.close();
		
	}

}
