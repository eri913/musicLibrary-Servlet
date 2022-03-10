package beans;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import servlets.ProductOrder;
public class User {
	
	private int id;
	private String email;
	private String name;
	private String surname;
	//Create a list of objects for each user's cart
	ArrayList<ProductOrder> usersCart = new ArrayList<ProductOrder>();
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	

}
