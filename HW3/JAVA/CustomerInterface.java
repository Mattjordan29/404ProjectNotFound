package mypackage;


public class CustomerInterface {
	
	boolean Authorization = true;
	
	public CustomerInterface() {
		
	}
	
	//Information is received from yes.jsp
	public void request(String Item, int Quantity, double TotalPrice, String AccountID, int PIN) {
		PurchaseOrderManager ordermanager = new PurchaseOrderManager();
		ordermanager.requestOrder(AccountID, PIN, Item, Quantity, TotalPrice);
		this.Authorization=ordermanager.authorization;
		
	}
	
	//information is received from no.jsp
	public void createAccRequestOrder(String AccountID, int PIN, int CardNo, String Item, int Quantity, double TotalPrice) {
		PurchaseOrderManager ordermanager = new PurchaseOrderManager();
		ordermanager.createAccRequestOrder(AccountID, PIN, CardNo, Item, Quantity, TotalPrice);
		this.Authorization=ordermanager.authorization;
	}
	
	//not used in this code.
	public void requestOrderWithNewCardNo(String AccountID, int PIN, int CardNo) {
		
	}
	
	//passes boolean back to yes.jsp or no.jsp
	public boolean getBoolean() {
		return Authorization;
	}
		


}