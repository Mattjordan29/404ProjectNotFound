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
	 <form method="post">

	<table border="2">
	<tr>
	<td>ACCOUNTID</td>
	<td>PIN</td>
	<td>CARDNO</td>
	<td>EMAIL</td>
	<td>
	</tr>
	  <%mysqlDWC sql2 = new mysqlDWC();
	  try {
			Class.forName("com.mysql.jdbc.Driver");
		
	  String url=sql2.getDataUrl();
	  String username=sql2.getUserName();
	  String password=sql2.getPassword();
	  String query="select * from Accounts";
	  Connection conn=DriverManager.getConnection(url,username,password);
	  Statement stmt=conn.createStatement();
	  ResultSet rs=stmt.executeQuery(query);
	  while(rs.next())
	  {

	  %>
	  <tr>
	      <td><%=rs.getString("ACCOUNTID") %></td>
	      <td><%=rs.getInt("PIN") %></td>
	      <td><%=rs.getInt("CARDNO") %></td>
	      <td><%=rs.getString("CUSTOMEREMAIL") %></td>
	      
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

</body>
</html>