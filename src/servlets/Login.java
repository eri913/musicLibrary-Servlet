package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address ="WEB-INF/jsp/login.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String email = request.getParameter("Customer email").trim();
		String pass = request.getParameter("Customer pass");
		
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
			Statement statement1 = con.createStatement();
			String sql = "SELECT email FROM users WHERE email='"+email+"';";
			String sql1 ="SELECT email, password, name, surname FROM users WHERE email='"+email+"' AND SHA1('"+pass+"')=password;";
			ResultSet result = statement.executeQuery(sql);	
			ResultSet result1 = statement1.executeQuery(sql1);	
			
			//
			if(result.next()) {
				if(result1.next()) {
					System.out.println("hi");
					User userlogin = new User();
					userlogin.setName(result1.getString("name"));
					
					HttpSession session = request.getSession();
					session.setAttribute("user", userlogin);
					
				}	
			}
			
	
		//redirect
		//String address =  "/WEB-INF/jsp/printProducts.jsp";
		request.getRequestDispatcher("/WEB-INF/jsp/printProducts.jsp").forward(request, response);
		
		}
		catch(SQLException sqle)
		{
			System.out.println("STEP 2 - connect to db error:\n" + sqle.getMessage());
		}

	
	}

}
