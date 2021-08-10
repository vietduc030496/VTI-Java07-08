package service;

import java.util.regex.Pattern;
import constant.NotificationConstant;

public class ValidateService {
	public void fieldNull(String s) {
		if (s == null) {
			throw new IllegalArgumentException(NotificationConstant.FIELD_NOT_NULL);
		}
	}

	public String name(String s) {
		fieldNull(s);
		String NAME_PATTERN = "^[a-zA-Z][\\w-]+$";
		if (Pattern.matches(NAME_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException(NotificationConstant.NAME_NOT_VALID);
	}

	public String email(String s) {
		fieldNull(s);
		String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
		if (Pattern.matches(EMAIL_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException(NotificationConstant.EMAIL_NOT_VALID);
	}

	public String date(String s) {
		fieldNull(s);
		String DATE_PATTERN = "^\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}$";
		if (Pattern.matches(DATE_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException(NotificationConstant.DATE_NOT_VALID);
	}

	public String phone(String s) {
		fieldNull(s);
		String PHONE_PATTERN = "\\d{10}";
		if (Pattern.matches(PHONE_PATTERN, s)) {
			return s;
		}
		throw new IllegalArgumentException(NotificationConstant.PHONE_NOT_VALID);
	}

	public void gender(int gender) {
		if (gender < 1 && gender > 3) {
			throw new IllegalArgumentException(NotificationConstant.DATA_NOT_VALID);
		}
	}
}
