package mypackage;


public class CustomerAccount {
	
	String AccountID;
	int PIN;
	int CardNo;
	String CustomerEmail;

	public CustomerAccount() {
		// TODO Auto-generated constructor stub
	}
	
	//If customer already has an account
	public void readAccountInfo(String AccountID, int PIN) {
		//get information from the database
		mysqlDWC sql = new mysqlDWC();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sql.Connection();
		this.AccountID=sql.GetAccountInfo(AccountID).AccountID;
		this.PIN=PIN;
		this.CardNo=sql.GetAccountInfo(AccountID).CardNo;
		this.CustomerEmail=sql.GetAccountInfo(AccountID).CustomerEmail;
	}
	
	//Creates account
	public void createAccount(String AccountID, int PIN, int CardNo, String CustomerEmail) {
		this.AccountID=AccountID;
		this.PIN=PIN;
		this.CardNo=CardNo;
		this.CustomerEmail=CustomerEmail;
		
		mysqlDWC sql = new mysqlDWC();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sql.Connection();
		//Adds the new account to the database
		sql.AddID(AccountID, PIN, CardNo, CustomerEmail);
	}
	
	//updates card no
	public void updateCardNo(String AccountID, int PIN, int CardNo, String CustomerEmail, int oldcardno) {
		mysqlDWC sql = new mysqlDWC();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sql.Connection();
		sql.ChangeAccountID(AccountID, PIN, oldcardno, CustomerEmail, CardNo);
		
	}
	
	

}
