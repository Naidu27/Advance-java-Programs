package com.staya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class ProdcutDao {

	public int save(Product pro) {
		
	  //declare the resource
		
		Connection connection=null;
		PreparedStatement  preparedStatement=null;
		int count=0;
      
		try {
			
			//get connection
			
			connection =Dbconnection.createConnection();
			
			System.out.println("connect mingindhi");
			
			//create prepared statement object
			
			preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");
			
			//read the data from product set the data
			
			preparedStatement.setString(1, pro.getProId());
			preparedStatement.setString(2,pro.getProName());
			
			preparedStatement.setDouble(3, pro.getProPrice());
			
			preparedStatement.setString(4,pro.getProBrand());
			
			preparedStatement.setString(5, pro.getProMadeIn());
			preparedStatement.setDate(6,pro.getProMfgDate());
			preparedStatement.setDate(7,pro.getProExpdate());
			
			preparedStatement.setBytes(8, pro.getProImage());
			preparedStatement.setBytes(9, pro.getProAudio());
			preparedStatement.setBytes(10, pro.getProVideo());
			
			System.out.println("data inserted");
			
			count =preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally {
			try {
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	
	}

	
	public List<Product> findAll() throws SQLException{
		
		
		List<Product> pro=new ArrayList<>();
		Product product=null;
		
		try(Connection connection=Dbconnection.createConnection();
				Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from product_data");
			
			while(resultSet.next())
			{
				product=new Product();
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProMfgDate(resultSet.getDate(6));
				product.setProExpdate(resultSet.getDate(7));
				product.setProImage(resultSet.getBytes(8));
				product.setProAudio(resultSet.getBytes(9));
				product.setProVideo(resultSet.getBytes(10));
				pro.add(product);
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pro;
	}
	
	public int deleteById(String  proId) {
		
		int count=0;
		
		try(Connection connection=Dbconnection.createConnection();
		   PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?"))
		{
			preparedStatement.setString(1, proId);
			count=preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public Product editById(String proId) {
		
		Product product=null;
	  
		try(Connection connection=Dbconnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select *  from product_data where proId=?"))
		{
			preparedStatement.setString(1, proId);
			ResultSet  resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				product=new Product();
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProMfgDate(resultSet.getDate("proMfgDate"));
				product.setProExpdate(resultSet.getDate("proExpdate"));
				product.setProImage(resultSet.getBytes("proImage"));
//				product.setProAudio(resultSet.getBytes("proAudio"));
//				product.setProVideo(resultSet.getBytes("proVideo"));
			}
		}
		catch(SQLException e) {
		
			e.printStackTrace();
		}
		return product;
		
	}
	
	public int updateById(Product product)
	{
	int updateResult=0;
	
	try( Connection connection=Dbconnection.createConnection()){
		
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE product_data SET proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpdate=?,proImage=?  WHERE proId=?");
		
		preparedStatement.setString(1, product.getProName());
		preparedStatement.setDouble(2,product.getProPrice());
		preparedStatement.setString(3,product.getProBrand());
		preparedStatement.setString(4,product.getProMadeIn());
		preparedStatement.setDate(5, product.getProMfgDate());
		preparedStatement.setDate(6, product.getProExpdate());
		preparedStatement.setBytes(7,product.getProImage());
//		preparedStatement.setBytes(8,product.getProAudio());
//		preparedStatement.setBytes(9,product.getProVideo());
		preparedStatement.setString(8, product.getProId());
		updateResult=preparedStatement.executeUpdate();
	}
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	return updateResult;
	}
	
	public List<Product> SearchByInput(String input){
		
		List<Product> pro=new ArrayList<Product>();
		
		String query="select * from Product_data where proId like ? or proName like ? or proBrand like ? or proMadeIn like ?";
		try( Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1,"%"+input+"%");
			preparedStatement.setString(2,"%"+input+"%");
			preparedStatement.setString(3,"%"+input+"%");
			preparedStatement.setString(4,"%"+input+"%");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			System.out.println("success");
			
			while(resultSet.next()) {
				Product product = new Product();
				
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProExpdate(resultSet.getDate("proExpdate"));
				product.setProMfgDate(resultSet.getDate("proMfgDate"));
		//		product.setProAudio(resultSet.getBytes("proAudio"));
		//		product.setProImage(resultSet.getBytes("proImage"));
		//		product.setProVideo(resultSet.getBytes("proVideo"));
				
				pro.add(product);
			}
		}
		
		catch(Exception e) {
		 
			e.printStackTrace();
	}
		return pro;
}
}
