package servlets;

import beans.Product;

//import coreservlets.CatalogItem;

public class ProductOrder {
	
	private Product aProduct;
	private int numOfProducts;

	public ProductOrder(Product aProduct) {
		setProduct(aProduct);
		setNumOfProducts(1);
	}

	public Product getProduct() {
		return(aProduct);
	}

	protected void setProduct(Product aProduct) {
		this.aProduct = aProduct;
	}

	public String getProductID() {
		return(getProduct().getId());
	}

	public String getProductInfo() {
		return(getProduct().getInfo());
	}

	public double getUnitCost() {
		return(getProduct().getPrice());
	}
		  
	public int getNumOfProducts() {
		return(numOfProducts);
	}

	public void setNumOfProducts(int n) {
		this.numOfProducts = n;
	}
	  
	public void incrementNumProducts() {
		setNumOfProducts(getNumOfProducts() + 1);
	}

	public void cancelOrder() {
		setNumOfProducts(0);
		  }

	public double getTotalCost() {
		return(getNumOfProducts() * getUnitCost());
	}
}


