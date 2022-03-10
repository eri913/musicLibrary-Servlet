package menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Menu_html {
	public static String getHeader(HttpServletRequest request){
		
	
	    HttpSession session = request.getSession();
		if(session.getAttribute("user_login") == null ) {
			return "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>myBoutique</title>\r\n" + 
					"\r\n" + 
					"<style>\r\n" + 
					"\r\n" + 
					"	body{\r\n" + 
					"		background: rgb(255, 0, 0, 0.2);\r\n" + 
					"		}"
					+ "h1{\r\n" + 
					"		text-align: center;\r\n" + 
					"		text-shadow: 2px 2px 5px #999999;\r\n" + 
					"		color: #262626;\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"	ul{\r\n" + 
					"		list-style-type: none;\r\n" + 
					"		margin: 0;\r\n" + 
					"		padding: 0;\r\n" + 
					"		overflow: hidden;\r\n" + 
					"		border: 1px solid #333333;\r\n" + 
					"		background-color: #696969;\r\n" + 
					"	   }\r\n" + 
					"	   \r\n" + 
					"	li{\r\n" + 
					"	   float: left;\r\n" + 
					"	   }\r\n" + 
					"	   \r\n" + 
					"	li a{\r\n" + 
					"		display: block;\r\n" + 
					"		color: #FFE4E1;\r\n" + 
					"		text-align: center;\r\n" + 
					"		padding:8px 16px;\r\n" + 
					"		text-decoration: none;\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"	li a:hover{\r\n" + 
					"		opacity: 0.5;\r\n" + 
					"		 }		\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					" <h1>My Boutique</h1>\r\n" + 
					"\r\n" + 
					" <ul>\r\n" + 
					"	<li><a href =\"index.html\">Home</a></li>\r\n" + 
					"	<li><a href = \"View_Product\">Clothes</a></li>\r\n" + 
					"	<li><a href = \"Shopping\">Cart</a></li>\r\n" +
					"   <li style=\"float:right\"><a href=\"Register\">Login</a></li>\r\n" +
					"   <li style=\"float:right\"><a href=\"Register\">Register</a></li>\n"+
					
					"</ul>";
		   
		}else {
			return "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>myBoutique</title>\r\n" + 
					"\r\n" + 
					"<style>\r\n" + 
					"\r\n" + 
					"	body{\r\n" + 
					"		background: rgb(255, 0, 0, 0.2);\r\n" + 
					"		}"
					+ "h1{\r\n" + 
					"		text-align: center;\r\n" + 
					"		text-shadow: 2px 2px 5px #999999;\r\n" + 
					"		color: #262626;\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"	ul{\r\n" + 
					"		list-style-type: none;\r\n" + 
					"		margin: 0;\r\n" + 
					"		padding: 0;\r\n" + 
					"		overflow: hidden;\r\n" + 
					"		border: 1px solid #333333;\r\n" + 
					"		background-color: #696969;\r\n" + 
					"	   }\r\n" + 
					"	   \r\n" + 
					"	li{\r\n" + 
					"	   float: left;\r\n" + 
					"	   }\r\n" + 
					"	   \r\n" + 
					"	li a{\r\n" + 
					"		display: block;\r\n" + 
					"		color: #FFE4E1;\r\n" + 
					"		text-align: center;\r\n" + 
					"		padding:8px 16px;\r\n" + 
					"		text-decoration: none;\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"	li a:hover{\r\n" + 
					"		opacity: 0.5;\r\n" + 
					"		 }		\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					" <h1>My Boutique</h1>\r\n" + 
					"\r\n" + 
					" <ul>\r\n" + 
					"	<li><a href =\"index.html\">Home</a></li>\r\n" + 
					"	<li><a href = \"View_Product\">Clothes</a></li>\r\n" + 
					"	<li><a href = \"Shopping\">Cart</a></li>\r\n" +
					"   <li style=\"float:right\"><a href=\"Register\">Register</a></li>\n"+
					"   <li style=\"float:right\"><a href=\"Logout\">Logout</a></li>\r\n" +
					"</ul>";
				
			}
					
	}
	
	public static String getFooter() {
		return"</body>"
				+ "</html>";
	}

}
