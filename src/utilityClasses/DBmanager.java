package utilityClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Product;

public class DBmanager {
	
	private static  ArrayList<Product> getProducts(){
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("STEP 1: driver detected!");
		} catch (ClassNotFoundException e) {
			System.out.println("STEP 1 - driver loading error:\n" + e.getMessage());
		}
		
		try {
			String url = "jdbc:mysql://127.0.0.1/myeshop";
			String username = "root";
			String password = "";
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("STEP 2: Connected to db!");
			
			Statement statement = con.createStatement();
			String sql = "SELECT name, id, info, price, img FROM products";
			ResultSet result = statement.executeQuery(sql);	
			
			ArrayList<Product> listOfProducts = new ArrayList<>();
			
			while(result.next())//
			{
				Product p = new Product();
				
				p.setName(result.getString("name"));
				p.setId(result.getString("id"));
				p.setInfo(result.getString("info"));
				p.setPrice(result.getFloat("price"));
				p.setImg(result.getString("img"));
			
				listOfProducts.add(p);
			}
	
			return listOfProducts;
		}
		catch(SQLException sqle)
		{
			System.out.println("STEP 2 - connect to db error:\n" + sqle.getMessage());
			return null;
			
		}	
	}
	
	//find the product from specific id
	public static Product findProduct(String productID) {
		
		ArrayList<Product> specifiedProduct = getProducts();
		for(Product p: specifiedProduct) {
			if(p.getId().equals(productID))
				return p;
		}
		return null;	
	}
}

