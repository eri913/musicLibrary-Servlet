package beans;

import java.util.*;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import beans.Product;
import servlets.ProductOrder;
import utilityClasses.DBmanager;

/** A shopping cart data structure used to track orders.
 *  The OrderPage servlet associates one of these carts
 *  with each user session.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */
 
public class ShoppingCart {
  private ArrayList<ProductOrder> productsOrdered;

  /** Builds an empty shopping cart. */
  
  public ShoppingCart() {
	  productsOrdered = new ArrayList<>();
  }

  /** Returns List of ProductOrder entries giving
   *  Item and number ordered. Declared as List instead
   *  of ArrayList so that underlying implementation
   *  can be changed later.
   */
  
  public List<ProductOrder> getItemsOrdered() {
    return(productsOrdered);
  }

  /** Looks through cart to see if it already contains
   *  an order entry corresponding to item ID. If it does,
   *  increments the number ordered. If not, looks up
   *  Item in catalog and adds an order entry for it.
   */
  
  public synchronized void addItem(String itemID) {
	
	ProductOrder order;
    for(int i=0; i<productsOrdered.size(); i++) {
      order = (ProductOrder)productsOrdered.get(i);
      if (order.getProductID().equals(itemID)) {
        order.incrementNumProducts();
        return;
      }
    }
   ProductOrder newOrder = new ProductOrder(DBmanager.findProduct(itemID));
   productsOrdered.add(newOrder);
   
  }

  /** Looks through cart to find order entry corresponding
   *  to item ID listed. If the designated number
   *  is positive, sets it. If designated number is 0
   *  (or, negative due to a user input error), deletes
   *  item from cart.
   */
  
  public synchronized void setNumOrdered(String itemID, int numOrdered) {
	ProductOrder order;
    for(int i=0; i<productsOrdered.size(); i++) {
      order = productsOrdered.get(i);
      if (order.getProductID().equals(itemID)) {
        if (numOrdered <= 0) {
        	productsOrdered.remove(i);
        } else {
          order.setNumOfProducts(numOrdered);
        }
        return;
      }
	}
    ProductOrder newOrder = new ProductOrder(DBmanager.findProduct(itemID));
    productsOrdered.add(newOrder);
  }
}
    
