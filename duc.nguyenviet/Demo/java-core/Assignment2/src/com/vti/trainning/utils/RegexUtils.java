package com.vti.trainning.utils;

import com.vti.trainning.constant.RegexConstant;

public class RegexUtils {

	public static boolean checkValidPhone(String phoneNumber) {
		return checkRegex(phoneNumber, RegexConstant.PHONE_PATTERN);
	}

	public static boolean checkValidEmail(String email) {
		return checkRegex(email, RegexConstant.EMAIL_PATTERN);
	}

	public static boolean checkRegex(String source, String regexPattern) {
		return source.matches(regexPattern);
	}
}
