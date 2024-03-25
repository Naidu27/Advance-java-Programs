package productpp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class productDao {

   /*  public  int createtable() {
    	 
    	 Connection connection=null;
 		
 		Statement Statement= null;
 		
 		int count=0;
 		
 		try {
 			
 			connection = Dbconnection.CreateConnection();
 			
 			Statement=connection.createStatement();
 			
 			count=Statement.executeUpdate("create table pro(proid number, proname varchar2(20), proprice number(10,2))");
 			
 		}
 		
 		catch (SQLException e){
 			
 			e.printStackTrace();
 		}
 		
 		return count;
    	
     }
}*/
  /*  public int save (Product pro) throws Throwable
	{
		Connection connection=null;
		
		PreparedStatement preparedStatement= null;
		
		int count=0;
	
	
	try {
		
		connection = Dbconnection.CreateConnection();
		
		preparedStatement=connection.prepareStatement(" insert into pro values(?,?,?)");
		
		preparedStatement.setInt(1, pro.getId());
		preparedStatement.setString(2, pro.getName());
		preparedStatement.setDouble(3, pro.getPrice());
		
		count=preparedStatement.executeUpdate();
		
	}
	
	catch (SQLException e){
		
		e.printStackTrace();
	}
	
	finally {
		
		if(connection!=null)
			connection.close();
		if(preparedStatement!=null)
			preparedStatement.close();
	}
	return count;

}*/
	
	/*public Product findById(int proId) {
		
		Product product=null;
		
		try(Connection connection=Dbconnection.CreateConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from pro where proId=?")
				)
		{
			preparedStatement.setInt(1, proId);
			ResultSet resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				product =new Product();
				
				product.setId(resultset.getInt(1));
				product.setName(resultset.getString(2));
				product.setPrice(resultset.getDouble(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}*/
	
	/*public List<Product> findAllProducts() 
	{
	
		List<Product> pro=new ArrayList<Product>();
		Product product=null;
		try(Connection connection=Dbconnection.CreateConnection();
			Statement statement=connection.createStatement())
		{
		   
			ResultSet resultSet=statement.executeQuery("select * from pro");
			
			product = new Product();
			while(resultSet.next())
			{
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getDouble(3));
                pro.add(product);
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
	  return pro;
		}*/
	   
	    
	public int updatePrice(double currentsPrice,double incPrice) throws SQLException
	{
           int count=0;	

      
           try(Connection connection=Dbconnection.CreateConnection();
        		   PreparedStatement preparedStatement=connection.prepareStatement("update pro set proprice= proprice+? where proprice>?"))
           {
        	   
			preparedStatement.setDouble(1,incPrice);
			preparedStatement.setDouble(2,currentsPrice);
			
			count=preparedStatement.executeUpdate();
           }
           
           catch(SQLException e)
           {
        	   e.printStackTrace();
           }
           
           return count;
           
	}
	
	public int deleteById(int proId) {
		
		int count=0;
		
		try(Connection connection=Dbconnection.CreateConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from pro where proId=?"))
		{
			preparedStatement.setInt(1,proId);
			count=preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
		
	}

	public int deleteByprice(int proPrice) {
		
		int count=0;
		try(Connection connection=Dbconnection.CreateConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from pro where proprice=?"))
		{
			preparedStatement.setDouble(1,124688);
			count=preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	

	public int DropTableProduct() {
		 Connection connection=null;
	 		
	 		Statement Statement= null;
	 		
	 		int count=0;
	 		
	 		try {
	 			
	 			connection = Dbconnection.CreateConnection();
	 			
	 			Statement=connection.createStatement();
	 			
	 			count=Statement.executeUpdate("drop table pro");
	 			
	 		}

		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}


}



