package mypackage;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class mysqlDWC 
{
	Connection connection = null; // manages connection
    Statement statement = null; // query statement
    ResultSet resultSet = null; // manages results
    final String DATABASE_URL = "jdbc:mysql://localhost/accountinfo";	//database URL
    final String UserName = "root";		//MySQL UserName please change
    final String Password = "Ogallala3";	//MySQL Password please change
    
    String AccountID;
    String Item;
    int Quantity;
    double TotalPrice;
    int AuthorizationNo;
    
   
                            
   public void Connection() {
	   
	   try 
	   {
		   connection = DriverManager.getConnection(DATABASE_URL, UserName, Password);
		   statement = connection.createStatement();
	   }
	   catch ( SQLException sqlException )                                
	   {                                                                  
	       sqlException.printStackTrace();
	   }  
   }

   public void GetOrderInfo() {
	   try
	   {
		   resultSet = statement.executeQuery(
				   "SELECT AccountID, Item, Quantity, TotalPrice, AuthorizationNo FROM OrderInfo");
		   
		   ResultSetMetaData metaData = resultSet.getMetaData();
		   int numberOfColumns = metaData.getColumnCount();	
		   
		   while( resultSet.next()) {
			   this.AccountID = resultSet.getString("AccountID");
			   this.Item = resultSet.getString("Item");
			   this.Quantity = resultSet.getInt("Quantity");
			   this.TotalPrice = resultSet.getDouble("TotalPrice");
			   this.AuthorizationNo = resultSet.getInt("AuthorizationNo");
			   
		   }
	   }
	   catch ( SQLException sqlException )                                
	      {                                                                  
	         sqlException.printStackTrace();
	      } // end)
		   
		   
		   
	   }
   
   
   public void DisplayOrder (){	
      
	   try 
	   {	                                 
		   resultSet = statement.executeQuery(            
           "SELECT AccountID, Item, Quantity, TotalPrice, AuthorizationNo FROM OrderInfo" );
         
		   ResultSetMetaData metaData = resultSet.getMetaData();
		   int numberOfColumns = metaData.getColumnCount();     
		   System.out.println( "Order Information:\n" );
         
		   for ( int i = 1; i <= numberOfColumns; i++ )
			   System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
		   System.out.println();
         
		   while ( resultSet.next() ) 
		   {
			   for ( int i = 1; i <= numberOfColumns; i++ )
				   System.out.printf( "%-8s\t", resultSet.getObject( i ) );
			   System.out.println();
		   } // end while 
         
	   }//end try
	   catch ( SQLException sqlException )                                
	   {                                                                  
	       sqlException.printStackTrace();
	   } // end catch  
   } //end DisplayAuthors
  
   public void DisplayID (){	
	      
	   try 
	   {	                                 
		   resultSet = statement.executeQuery(            
           "SELECT AccountID, PIN, CardNo, CustomerEmail FROM Accounts" );
         
		   ResultSetMetaData metaData = resultSet.getMetaData();
		   int numberOfColumns = metaData.getColumnCount();     
		   System.out.println( "Accounts:\n" );
         
		   for ( int i = 1; i <= numberOfColumns; i++ )
			   System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
		   System.out.println();
         
		   while ( resultSet.next() ) 
		   {
			   for ( int i = 1; i <= numberOfColumns; i++ )
				   System.out.printf( "%-8s\t", resultSet.getObject( i ) );
			   System.out.println();
		   } // end while 
         
	   }//end try
	   catch ( SQLException sqlException )                                
	   {                                                                  
	       sqlException.printStackTrace();
	   } // end catch  
   } //end DisplayAuthors
   
   
   
   public CustomerAccount GetAccountInfo(String ID) {
	   CustomerAccount account = new CustomerAccount();
	   ID="'" + ID + "'";
	   
	   try
	   {
		   resultSet= statement.executeQuery(
				   "SELECT AccountID, PIN, CardNo, CustomerEmail FROM Accounts WHERE AccountID =" + ID);
		   
		   ResultSetMetaData metaData = resultSet.getMetaData();
		   int numberOfColumns = metaData.getColumnCount();	
		   
		   while( resultSet.next()) {
			   account.AccountID = resultSet.getString("AccountID");
			   account.PIN = resultSet.getInt("PIN");
			   account.CardNo = resultSet.getInt("CardNo");
			   account.CustomerEmail = resultSet.getString("CustomerEmail");
			   
		   }
	   }
	   catch ( SQLException sqlException )                                
	      {                                                                  
	         sqlException.printStackTrace();
	      } // end catch 
	   
	   
	   return account;
	   
   }
   
   public void ChangeAccountID (String AccountID, int PIN, int CardNo, String CustomerEmail, int newCardNo) {
	 
	   try 
	   {                               
		   String query = " update Accounts SET AccountID = ?, PIN = ?, CardNo = ?, CustomerEmail = ? where AccountID = ?";
		   
		   PreparedStatement preparedStmt = connection.prepareStatement(query);
		      
		   preparedStmt.setString (1, AccountID);
		   preparedStmt.setInt (2, PIN);
		   preparedStmt.setInt (3, newCardNo);
		   preparedStmt.setString(4, CustomerEmail);
		   preparedStmt.setString(5, AccountID);
		   preparedStmt.executeUpdate(); 
		   
	   }
	   catch ( SQLException sqlException)                                
	   {                                                                  
	       sqlException.printStackTrace();
	   } // end catch  
   }
   
  
   
   
   public void AddID (String AccountID, int PIN, int CardNo, String CustomerEmail) {
	   
	try 
	{
		String query = " insert into Accounts (AccountID, PIN, CardNo, CustomerEmail)" + " values (?, ?, ?, ?)";

	    PreparedStatement preparedStmt = connection.prepareStatement(query);
	    preparedStmt.setString(1, AccountID);
	    preparedStmt.setInt (2, PIN);
	    preparedStmt.setInt (3, CardNo);
	    preparedStmt.setString(4, CustomerEmail);
		
	    preparedStmt.execute(); 
	}
	catch (SQLException sqlException)                                
    {                                                                  
        sqlException.printStackTrace();
    } // end catch  
   }
   
   public void AddOrder (String AccountID, String Item, int Quantity, double TotalPrice, int AuthorizationNo) {
	  
	   try
	   {
		   String query = " insert into OrderInfo (AccountID, Item, Quantity, TotalPrice, AuthorizationNo)" + " values (?, ?, ?, ?, ?)";
		   
		   PreparedStatement preparedStmt = connection.prepareStatement(query);
		   preparedStmt.setString(1, AccountID);
		   preparedStmt.setString (2, Item);
		   preparedStmt.setInt (3, Quantity);
		   preparedStmt.setDouble(4, TotalPrice);
		   preparedStmt.setInt(5, AuthorizationNo);
		   
		   preparedStmt.execute();
	   }
	   catch (SQLException sqlException)                                
	    {                                                                  
	        sqlException.printStackTrace();
	    } // end catch 
   }
   
   	public void DeleteOrders() {
	   
	   try
	   {
		   String query = " DELETE FROM OrderInfo";
		   PreparedStatement preparedStmt = connection.prepareStatement(query);
		   preparedStmt.execute();
	   }
	   catch (SQLException sqlException)                                
	    {                                                                  
	        sqlException.printStackTrace();
	    } // end catch  
   }
   
   	public void DeleteAccounts() {
	   
	   try
	   {
		   String query = " DELETE FROM Accounts";
		   PreparedStatement preparedStmt = connection.prepareStatement(query);
		   preparedStmt.execute();
	   }
	   catch (SQLException sqlException)                                
	    {                                                                  
	        sqlException.printStackTrace();
	    } // end catch  
   }
   	
   	public String getDataUrl() {
   		return DATABASE_URL;
   	}
   	public String getUserName() {
   		return UserName;
   	}
   	public String getPassword() {
   		return Password;
   	}
   	
   
}



