package vti.exercise1.entity;

public class Invoice implements Payable {
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
