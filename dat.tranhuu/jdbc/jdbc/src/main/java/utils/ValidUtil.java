package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import constant.RegexConstant;

public class ValidUtil {

	public static boolean validEmail(String email) {
		if (email.matches(RegexConstant.regexEmail)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validPhone(String phone) {
		if (phone.matches(RegexConstant.regexPhone) && phone.length() >= 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validDate(String date) {
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			spd.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean validDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
