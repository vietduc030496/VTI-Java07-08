package vti;

public class Invoice implements Payable{
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePeritem;
	
	public Invoice() {
		
	}



	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
