package produce;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureExcutionex {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sai","welcome");
        
		CallableStatement callableStatement=connection.prepareCall("{call getsal(?,?)}");
		callableStatement.setInt(1, 111);
		
		callableStatement.registerOutParameter(2,Types.FLOAT);
		callableStatement.executeUpdate();
		
		System.out.println(callableStatement.getFloat(2));
		
		connection.close();
		
	}

}
