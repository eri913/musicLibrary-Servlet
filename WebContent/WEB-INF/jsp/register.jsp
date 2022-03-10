<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

</body>
<head>
<meta charset="UTF-8">
	 <link rel="stylesheet" href="./css/Style.css" type="text/css"/>
	<title>SoundLibrary</title>
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
	<form action="Register" method ="post">
	
	<p style="font-size:25px">Register</p>
	<label for="Customer name">Name</label><br>
	<input type = "text" name = "Customer name" size="20" placeholder="Your name.."required><br>
	<br>
	<label for="Customer surname">Surname</label><br>
    <input type = "text" name = "Customer surname" size="20" placeholder="Your last name.." required><br>
    <br>
    <label for="Customer email">E-mail</label><br>
	<input type = "text" name = "Customer email" size="20" placeholder="Your e-mail.." required><br>
	<br>
	<label for="Customer pass">Password</label><br>
	<input type = "password" name = "Customer pass" size="20" placeholder="Your password.." required><br>
	<br>
	<label for="Conf pass">Confirm Password</label><br>
	<input type = "password" name = "Conf pass" placeholder="Confirm your password.." size="20" required><br>
	<br>
	<input type = "submit" value = "Ok">
	</form>

</body>

</html>