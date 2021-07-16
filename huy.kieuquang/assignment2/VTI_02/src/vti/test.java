package vti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		String emailParttern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		String phoneRegex = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
		String email = "abc@gmail.com";
		String phone = "0898201199";
		System.out.println(email.matches(emailParttern));
		System.out.println(phone.matches(phoneRegex));
	}
}
