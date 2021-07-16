package com.vti.assignment2.entity;

public class Invoice implements Payable{
	private  String partNumber;
	private String  partDescription;
	private int quantity;
	private double pricePeritem;
	
	
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
