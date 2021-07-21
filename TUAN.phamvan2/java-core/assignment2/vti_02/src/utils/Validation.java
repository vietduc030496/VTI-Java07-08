package utils;

import java.text.SimpleDateFormat;
import constant.Constant;

public class Validation {
	public static boolean isValidEmail(String email) {
		return email.matches(Constant.regexEmail);
	}

	public static boolean isValidPhone(String phone) {
		return phone.matches(Constant.regexPhone);
	}

	public static boolean isValidDate(String birthDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			format.parse(birthDate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
