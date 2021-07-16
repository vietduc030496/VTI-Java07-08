package b2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Employee implements Payable {
	private String ssn;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee() {
		super();
	}

	public Employee(String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}
	
	public void display() {
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean validPhone=true;
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
		String phone="";
//		while(validPhone) {
//			
//			phone=(input.nextLine());
//			if(phone.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
//				validPhone=false;
//				System.out.println("valid");
//			}else {
//				System.out.println("input");
//			}
//			 
//		}
		while(validPhone) {
			phone=(input.nextLine());
			try {
				Double.parseDouble(phone);
				validPhone=false;
		     }
		     catch(Exception e){
		    	 validPhone=true;
		    	 System.out.println("invalid date, input birthDate again: ");
		     } 
		}
		
		input.close();
	}

}
