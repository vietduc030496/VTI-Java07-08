package constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	public static boolean isValidEmail(String email) {
		String regex = "^(.+)@(.+)$";
		return email.matches(regex);
	}

	public static boolean isValidPhone(String phone) {
		String regex = "^\\d{7}$";
		return phone.matches(regex);
	}
	
	public static boolean isValidDate(String birthDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			format.parse(birthDate);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean isValidDepartment(String department) {
		String regex = "[A-Z0-9]{2}";
		return department.matches(regex);
	}
	
	
}
