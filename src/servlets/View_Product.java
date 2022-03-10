package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;



@WebServlet("/View_Product")
public class View_Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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

			request.setAttribute("products", listOfProducts);
			
		}
		
		catch(SQLException sqle)
		{
			System.out.println("STEP 2 - connect to db error:\n" + sqle.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/printProducts.jsp");
		dispatcher.forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
}
