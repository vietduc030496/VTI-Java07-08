package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import constant.Constant;

public class ValidUtil {

	public static boolean validEmail(String email) {
		if (email.matches(Constant.regexEmail)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validPhone(String phone) {
		if (phone.matches(Constant.regexPhone) && phone.length() > 6) {
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
