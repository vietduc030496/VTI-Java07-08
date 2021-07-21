package vti.exercise1.service;

import java.util.regex.Pattern;

public class ValidateData {
	public String name(String s) {
		String NAME_PATTERN = "^[a-zA-Z][\\w-]+$";
		if (Pattern.matches(NAME_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException("Ten khong hop le !");
	}

	public String email(String s) {
		String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
		if (Pattern.matches(EMAIL_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException("Email khong hop le !");
	}

	public String date(String s) {
		String DATE_PATTERN = "^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$";
		if (Pattern.matches(DATE_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException("Ngay thang ko hop le !");
	}

	public String phone(String s) {
		String PHONE_PATTERN = "\\d{7}";
		if (Pattern.matches(PHONE_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException("Sdt co 7 chu so !");
	}
}
