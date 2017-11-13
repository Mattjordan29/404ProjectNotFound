package mypackage;


public class DeliveryOrder {
	
	String AccountId;
	String Item;
	int Quantity;
	double TotalPrice;
	int AuthorizationNo;

	public DeliveryOrder() {
		// TODO Auto-generated constructor stub
	}
	
	//creates order and adds it to the database
	public void createOrder(String AccountID, String Item, int Quantity, double TotalPrice, int AuthorizationNo) {
		mysqlDWC sql = new mysqlDWC();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.Connection();
		sql.AddOrder(AccountID, Item, Quantity, TotalPrice, AuthorizationNo);
	}
	
	

}
