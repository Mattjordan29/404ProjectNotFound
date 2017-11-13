package mypackage;

import java.util.Scanner;

public class BankInterface {
	
	public BankInterface() {
		
	}
	
	public boolean Authorize(CustomerAccount account) {
		//Calls mysql to get information from the database
		mysqlDWC sql = new mysqlDWC();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sql.Connection();
		
		//Checks if the PINS are the same
		if(account.PIN == sql.GetAccountInfo(account.AccountID).PIN) {
			return true;
		}else {
			return false;
		}
		
	}

}
