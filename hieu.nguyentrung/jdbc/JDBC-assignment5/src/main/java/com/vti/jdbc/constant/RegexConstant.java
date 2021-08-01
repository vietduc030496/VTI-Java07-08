package com.vti.jdbc.constant;


public class RegexConstant {
	private RegexConstant() {
	}

	public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

	public static final String PHONE_PATTERN = "^\\d{10}$";
	
	public static final String BIRTHDATE_PATTERN = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
	
	
	
}
