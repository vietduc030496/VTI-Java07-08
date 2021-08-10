package ToolJDBC.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Validate {
	public boolean validateBrithday(String strDate) {
		if (strDate.trim().equals("")) {
			return false;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);

			try {
				Date date =  sdf.parse(strDate);

			} catch (ParseException e) {
				System.out.println(strDate + " is not valid format");
				return false;
			}

			return true;
		}
	}

	public boolean validatePhone(String phone) {
		String phoneRegex = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
		return phone.matches(phoneRegex);
	}

	public boolean validateEmail(String email) {
		String emailParttern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

		return email.matches(emailParttern);
	}
	
	
}
