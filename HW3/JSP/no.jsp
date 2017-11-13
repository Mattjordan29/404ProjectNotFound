<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Random" %>
    <%@ page import="mypackage.CustomerInterface"%>
    <%@ page import="mypackage.mysqlDWC"%> 
    <%@ page import="java.sql.Connection" %>
	<%@ page import= "java.sql.ResultSet" %>
	<%@ page import= "java.sql.ResultSetMetaData" %>
	<%@ page import= "java.sql.SQLException" %>
	<%@ page import= "java.sql.Statement" %>	
	<%@ page import= "java.sql.*" %>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Enter in your information</h2>

 <form method="post">
   Quantity <input type="text" id="Quantity" name="Quantity" />
   AccountID <input type="text" id="accountID" name="accountID" />
   PIN <input type="text" id="PIN" name="PIN" />
   CardNo <input type="text" id="CardNo" name="CardNo" />
   
   <input type="submit" value="Submit">
   <input type="button" value="Cancel" name="item" onclick="window.location='Cancel.jsp'">
   <input type="button" value="Database Displays" name="item" onclick="window.location='Database.jsp'">
   
  </form>
  
  <%

  String Item = request.getParameter("inputName");
  String AccountID = request.getParameter("accountID");
  String Parameter = request.getParameter("PIN");
  String Card = request.getParameter("CardNo");
  String getQuantity = request.getParameter("Quantity");
  double price = 0;
  if(Item.equals("apple")){
	  price=1.00;
  }
  if(Item.equals("banana")){
	  price=2.50;
  }
  if(Item.equals("orange")){
	  price=2.30;
  }
 
  
  if(Parameter != null){
	  if(Item != null){
		  if(AccountID != null){
			  if(Card != null){
  int PIN  = Integer.parseInt(Parameter);
  int CardNo = Integer.parseInt(Card);
  CustomerInterface Interface = new CustomerInterface();
  Random rand = new Random();
  int Quantity = Integer.parseInt(getQuantity);
  double TotalPrice = Quantity*price;
  Interface.createAccRequestOrder(AccountID, PIN, CardNo, Item, Quantity, TotalPrice);
		  
  
  if(Interface.getBoolean() == true){%>
  	  <h2>Account Created</h2>
	  <h2>Account Authorized</h2>
	  <h3>Email sent to - </h3>
	  <input type="text" name="text1" size="100" value="<%=AccountID + "@ttu.edu" %>">	 
	  <form method="post">

	<table border="2">
	<tr>
	<td>ACCOUNTID</td>
	<td>ITEM</td>
	<td>QUANTITY</td>
	<td>TOTALPRICE</td>
	<td>AUTHORIZATIONNO</td>
	<td>
	</tr>
	  <%mysqlDWC sql = new mysqlDWC();
	  try {
			Class.forName("com.mysql.jdbc.Driver");
		
	  String url=sql.getDataUrl();
	  String username=sql.getUserName();
	  String password=sql.getPassword();
	  String query="select * from OrderInfo";
	  Connection conn=DriverManager.getConnection(url,username,password);
	  Statement stmt=conn.createStatement();
	  ResultSet rs=stmt.executeQuery(query);
	  while(rs.next())
	  {

	  %>
	  <tr>
	      <td><%=rs.getString("ACCOUNTID") %></td>
	      <td><%=rs.getString("ITEM") %></td>
	      <td><%=rs.getInt("QUANTITY") %></td>
	      <td><%=rs.getDouble("TOTALPRICE") %></td>
	      <td><%=rs.getInt("AUTHORIZATIONNO") %></td>
	       </tr>   <%

	  }
	  %>
	      </table>
	      <%
	      rs.close();
	      stmt.close();
	      conn.close();
	      }
	  catch(Exception e)
	  {
	      e.printStackTrace();
	      }




	  %>
	 </form>
	 
	 
  <% }else{%>
  	<h2>PIN Incorrect!</h2>>
	<h2>Try again! </h2>  
  <% } 
	  }
		  }
	  }
  }
  
 
  %>

</body>
</html>