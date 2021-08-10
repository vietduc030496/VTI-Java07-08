package com.vti.jdbc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.jdbc.constant.RegexConstant;

public class RegexUtils {

	public static boolean checkBirthDate(String birthDate) {
		return checkRegex(birthDate, RegexConstant.BIRTHDATE_PATTERN);
	}
	
	public static boolean checkValidPhone(String phoneNumber) {
		return checkRegex(phoneNumber, RegexConstant.PHONE_PATTERN);
	}
	
	public static boolean checkValidEmail(String email) {
		return checkRegex(email, RegexConstant.EMAIL_PATTERN);
	}
	
	public static boolean checkRegex (String source, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches() == true) {
			return true;
		} else {
			return false;
		}
	}
}
