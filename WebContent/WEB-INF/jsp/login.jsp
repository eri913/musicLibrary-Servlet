<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	 <link rel="stylesheet"
	      href="./css/Style.css"
	      type="text/css"/>
<title>login</title>
<style>
	label{
		margin: 10px 120px;
	}
	
	input[type=text], input[type=password] {
		width: 30%;
  		padding: 12px 20px;
  		margin: auto;
  		border: none ;
  		border-left: 2px solid #666666;
  }
  
  	input[type=submit] {
  		width: 10%;
  		background-color: #357379;
  		color: #f7f7f7 ;
  		padding: 10px 20px;
  		margin: auto;
  		border: none;
  		border-radius: 4px;
  		cursor: pointer;
   }
  	
  </style>
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
	<div>
	<p style="font-size:25px">Login</p>
	<form action="Shopping" method ="post">
	<label for="Customer emai">E-mail</label><br>
	<input type = "text" name = "Customer email" size="20" placeholder="Your e-mail.." required><br>
	<br>
	<label for="Customer pass">Password</label><br>
	<input type = "password" name = "Customer pass" size="20" placeholder="Your password.." required><br>
	<br>
	<input type = "submit" value = "Login">
	</form>
	</div>

</body>
</html>