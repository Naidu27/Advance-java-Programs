package produceex2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Procedureexp2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ex","sai","welcome");

	 CallableStatement callableStatement=connection.prepareCall("{call getAll(?,?,?,?)}");
	 
	 callableStatement.setInt(1,111);
	 
	 callableStatement.registerOutParameter(2, Types.FLOAT);
	 callableStatement.registerOutParameter(3, Types.VARCHAR);
	 callableStatement.registerOutParameter(4, Types.INTEGER);
	 
	 
	 callableStatement.executeUpdate();
	 
	 System.out.println(callableStatement.getFloat(2));
	 System.out.println(callableStatement.getDouble(3));
	 System.out.println(callableStatement.getInt(4));
	 }

}
