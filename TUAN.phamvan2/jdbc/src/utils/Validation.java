package utils;

import java.text.SimpleDateFormat;

import constant.RegexConstant;

public class Validation {
	public static boolean isValidEmail(String email) {
		return email.matches(RegexConstant.regexEmail);
	}

	public static boolean isValidPhone(String phone) {
		return phone.matches(RegexConstant.regexPhone);
	}

	public static boolean isValidDate(String birthDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.parse(birthDate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
