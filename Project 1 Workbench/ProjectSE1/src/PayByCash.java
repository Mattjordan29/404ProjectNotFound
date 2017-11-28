public class PayByCash
{
	public int Due;
	public int Paid;
	public int Change;
	
	public void CashPayment(int AmountDue, int AmountPaid)
	{
		Due = AmountDue;
		Paid = AmountPaid;

		while(Due-Paid > 0)
		{
			Due = Due - Paid;
			System.out.println("Amount still due: " + Due);
		}
		if (Due-Paid == 0)
		{
			Change = 0;
		}else if(Due-Paid < 0)
		{
			Change = Due - Paid;
		}
	}
	public void PrintReciept(int AmountDue, int AmountPaid, int AmountChange)
	{
		System.out.println("Amount Due: " + AmountDue +"\n" +"Amount Paid: "+ AmountPaid + "\n" + "Change: " + Change);
	}
}