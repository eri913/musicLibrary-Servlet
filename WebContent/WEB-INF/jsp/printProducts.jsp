<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "beans.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	 <link rel="stylesheet" href="./css/Style.css" type="text/css"/>
<title>SoundLibrary</title>
</head>
<body>
    <h1>My Sound Library</h1>
     <ul>
		<li><a href ="index.html">Home</a></li>
		<li><a href = "View_Product">Products</a></li>
		<li><a href = "Shopping">Cart</a></li>
		<li><a href="Login">Login</a></li>
		<li><a href="Register">Register</a></li>
    </ul>
<% ArrayList<Product> product = (ArrayList<Product>) request.getAttribute("products");
for(Product p:product){
    String formURL = "Shopping";
    formURL = response.encodeURL(formURL);%>
	<form action=<%=formURL%> method="post">
		<h2> <%=p.getName() %> </h2>
		<p>
			<%= p.getInfo() %>
		<br>
			<b>Price:</b>
			<%= p.getPrice() %> &euro;</p> <img src="<%= p.getImg() %>">
		<br>
		<label for="quantity">Quantity</label>
		<input type="text"  value="1" name="quantity" min="1" max="5">
		<input type="hidden" name="productID" value=<%=p.getId()%>>
		<input  class="addtocart" type="submit" name="prod" value="Add to Cart">
		<hr style="width:80%;text-align:left;margin-left:0">
		<br>
	</form>
<%} %>

</body>
</html>

