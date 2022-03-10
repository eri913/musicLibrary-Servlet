<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList"%>
    <%@ page import = "servlets.ProductOrder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	 <link rel="stylesheet" href="./css/Style.css" type="text/css"/>
<title>Cart</title>
</head>
<body>
<h1>Cart</h1>
     <ul>
		<li><a href ="index.html">Home</a></li>
		<li><a href = "View_Product">Products</a></li>
		<li><a href = "Shopping">Cart</a></li>
		<li><a href="Login">Login</a></li>
		<li><a href="Register">Register</a></li>
    </ul>
    <br>
<% ArrayList<ProductOrder> items = (ArrayList<ProductOrder>) request.getAttribute("items");%>
	<% if(items.size()==0) { %>
		<h2><i>No items in your cart...</i></h2>
    <%} else {%>
        <table border=1 align="center">
         <tr bgcolor="#357379">
         <th>Item ID<th>Description<th>Unit Cost<th>Number<th>Total Cost
        
	<%for(int i=0; i<items.size(); i++) {%>
		<tr>
		<td> <%=items.get(i).getProduct().getName()%>
	    <td> <%=items.get(i).getProductInfo()%>
	    <td> <%=items.get(i).getUnitCost()%>
	    <td><form action="Shopping" method="post">
	    	<input type="hidden" name="itemID" value= <%=items.get(i).getProductID() %>>
	        <input type="text" name="numItems" size=3 value= <%=items.get(i).getNumOfProducts()%>>
	        <small>
	        	<input  type="submit" value= "Update Order">
	        </small>
	        </form>
	        <td><%=items.get(i).getTotalCost()%>
   <% }}%>

</body>
</html>