<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Apples cost $1.00</h2>

<h2>Do you have an account?</h2>

<form action="yes.jsp" method="GET">
    <input type="hidden" id="thisField" name="inputName" value="apple">
<input type="submit" value="Yes">   
</form>

<form action="no.jsp" method="GET">
    <input type="hidden" id="thisField" name="inputName" value="apple">
<input type="submit" value="No">   
</form>

</body>
</html>