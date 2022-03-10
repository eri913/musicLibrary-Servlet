package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address =  "/WEB-INF/jsp/register.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String name = request.getParameter("Customer name");
		String surname = request.getParameter("Customer surname");
		String email = request.getParameter("Customer email").trim();
		String pass1 = request.getParameter("Customer pass");
		String pass2 = request.getParameter("Conf pass");
		
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
			String sql = "SELECT email FROM users WHERE email='"+email+"';";
			ResultSet result = statement.executeQuery(sql);
			
		if(pass1.equals(pass2)){
			if(!result.next()) {
				Statement statement1 = con.createStatement();
				String sql1= "INSERT INTO users (name, surname, email, password) VALUES('"+name+"','"+surname+"','"+email+"',SHA1('"+pass1+"'));";
				statement1.executeUpdate(sql1);
			}	
		}
		//redirect
		String address =  "/WEB-INF/jsp/register.jsp";
		request.getRequestDispatcher(address).forward(request, response);
		
	}
		catch(SQLException sqle)
		{
			System.out.println("STEP 2 - connect to db error:\n" + sqle.getMessage());
		}

	}

}
