<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Screen</title>
</head>
<body>
	<h1>WELCOME!</h1>
	<h2>Choose an item you would like to buy</h2>

  <form method="get">
    <input type="button" value="Apple" name="item" onclick="window.location='Apple.jsp'">
    <input type="button" value="Banana" name="item" onclick="window.location='Banana.jsp'">
    <input type="button" value="Orange" name="item" onclick="window.location='Orange.jsp'">
  </form>
	
	
</body>

</html>