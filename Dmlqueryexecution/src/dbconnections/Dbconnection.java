package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	// This method create the connection & return connection
     public static Connection CreateConnection()
     {
    	 Connection connection=null;
     
     
     try {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","sai","welcome");
     }
     catch(ClassNotFoundException| SQLException e)
     {
    	e.printStackTrace(); 
     }
     
        return connection;
     }
}
