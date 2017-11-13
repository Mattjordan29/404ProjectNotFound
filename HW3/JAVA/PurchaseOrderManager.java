package mypackage;

import java.util.Random;
import java.util.Scanner;

public class PurchaseOrderManager {
	boolean authorization = true;

	public PurchaseOrderManager() {
		
	}
	
	//request order, if user already has an account, authorization number is randomized
	public void requestOrder(String AccountID, int PIN, String Item, int Quantity, double TotalPrice) {
		CustomerAccount account = new CustomerAccount();
		account.readAccountInfo(AccountID, PIN);
		BankInterface bank = new BankInterface();
		
		
		authorization = bank.Authorize(account);
		if(authorization == true) {
			DeliveryOrder order = new DeliveryOrder();
			int AuthorizationNo = 1234;
			Random rand = new Random();
			AuthorizationNo = rand.nextInt(10000);
			
			order.createOrder(AccountID, Item, Quantity, TotalPrice, AuthorizationNo);
			EmailServerInterface email = new EmailServerInterface();
			email.emailConfirmation(account.CustomerEmail);
			
		}else {
		
		}
	}
			
		
			
	//used if user needs to creates an account, authorization number is randomized
	public void createAccRequestOrder(String AccountID, int PIN, int CardNo, String Item, int Quantity, double TotalPrice) {
		CustomerAccount account = new CustomerAccount();
		String CustomerEmail = AccountID + "@ttu.edu";
		account.createAccount(AccountID, PIN, CardNo, CustomerEmail);
		BankInterface bank = new BankInterface();
		
		boolean authorization;
		authorization = bank.Authorize(account);
		
		if(authorization == true) {
			DeliveryOrder order = new DeliveryOrder();
			int AuthorizationNo = 1234;
			Random rand = new Random();
			AuthorizationNo = rand.nextInt(10000);
			
			order.createOrder(AccountID, Item, Quantity, TotalPrice, AuthorizationNo);
			EmailServerInterface email = new EmailServerInterface();
			email.emailConfirmation(account.CustomerEmail);
			
		}else {
		}
	}
	
			
	//used if user wants to use a new card no, not used since user can create a new one in the jsp file
	public void requestOrderWithNewCardNo(String AccountID, int PIN, int CardNo, String Item, int Quantity, double TotalPrice, int oldcardno) {
		CustomerAccount account = new CustomerAccount();
		account.updateCardNo(AccountID, PIN, CardNo, AccountID + "@ttu.edu", oldcardno);
		
		BankInterface bank = new BankInterface();
		
		boolean authorization;
		authorization = bank.Authorize(account);
		
		if(authorization == true) {
			DeliveryOrder order = new DeliveryOrder();
			int AuthorizationNo = 0;
			Random rand = new Random();
			AuthorizationNo = rand.nextInt(10000);
			order.createOrder(AccountID, Item, Quantity, TotalPrice, AuthorizationNo);
			EmailServerInterface email = new EmailServerInterface();
			email.emailConfirmation(account.CustomerEmail);
			
		}else {
		}
}
	}