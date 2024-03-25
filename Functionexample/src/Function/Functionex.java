package Function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Functionex {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","sai","welcome");

		CallableStatement callableStatement=connection.prepareCall("{?= call getAvg(?,?)}");
		
		callableStatement.setInt(2,111);
		callableStatement.setInt(3,112);
		
		callableStatement.registerOutParameter(1, Types.DOUBLE);
		
		callableStatement.executeUpdate();
		
		System.out.println(callableStatement.getDouble(0));
		
		connection.close();
	}

}
