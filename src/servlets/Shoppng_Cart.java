package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;
import beans.User;
import beans.ShoppingCart;


@WebServlet("/Shopping")
public class Shoppng_Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String address="";
		
		if(session.getAttribute("user")==null) 
			address="WEB-INF/jsp/login.jsp";
		else 
			address="WEB-INF/jsp/cart.jsp";
		
		request.getRequestDispatcher(address).forward(request, response);	
		
		
	}

	
	      
		
//		//user add product in cart 
//		Product order = (Product) request.getAttribute("p");
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
//		Integer productQuantity = new Integer(quantity);
//		order.setQuantity(productQuantity);
//		
//		signInUser.productsIntoCart(order, productQuantity);
//		request.getRequestDispatcher("/WEB-INF/jsp/printProducts.jsp").forward(request, response);
//		
//		//String address =  "/WEB-INF/jsp/shopCart.jsp";
//		//request.getRequestDispatcher(address).forward(request, response);
//		


//		
//		if(session.getAttribute("user") == null) {
//			request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
//		}
//		
//		request.getRequestDispatcher("WEB-INF/jsp/showCart.jsp").forward(request, response);
			



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		HttpSession session = request.getSession();
		ShoppingCart aCart = null;
	    synchronized(session) {
	      aCart = (ShoppingCart)session.getAttribute("shoppingCart");
	      // New visitors get a fresh shopping cart.
	      // Previous visitors keep using their existing cart.
	      if (aCart == null) {
	    	  aCart = new ShoppingCart();
	          session.setAttribute("shoppingCart", aCart);
	      }
	      String itemOrderdID = request.getParameter("productID");
	      System.out.println(itemOrderdID);//DEBUG
	      if (itemOrderdID != null) {
	        String numItemsString = request.getParameter("quantity");
	        if (numItemsString != null) {
	          // If request specified an ID but no number,
	          // then customers came here via an "Add Item to Cart"
	          // button on a catalog page.
	          aCart.addItem(itemOrderdID);
	        } else {
	          // If request specified an ID and number, then
	          // customers came here via an "Update Order" button
	          // after changing the number of items in order.
	          // Note that specifying a number of 0 results
	          // in item being deleted from cart.
	          int numItems;
	          try {
	            numItems = Integer.parseInt(numItemsString);
	          } catch(NumberFormatException nfe) {
	            numItems = 1;
	          }
	          aCart.setNumOrdered(itemOrderdID, numItems);
	        }
	      }
	    }
	    // Whether or not the customer changed the order, show
	    // order status.

	    synchronized(session) {
	      List<ProductOrder> itemsOrdered = aCart.getItemsOrdered();
		  request.setAttribute("items", itemsOrdered);
		  request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
    
	        }
		}
}

